package cn.gn.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;
import cn.gn.web.service.NewsService;

/**
 * Servlet implementation class NewsController
 */
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		NewsService ns = (NewsService)ac.getBean("newServiceImpl");
		String content = request.getParameter("content");
		//获取当前页面
		String curpage = request.getParameter("curPage");
		PageTools list = ns.queryNewsByContent(content,curpage);
		request.setAttribute("newsList", list);
		request.setAttribute("content",content );
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
