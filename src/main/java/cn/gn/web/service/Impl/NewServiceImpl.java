package cn.gn.web.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;
import cn.gn.web.dao.NewsDao;
import cn.gn.web.service.NewsService;

/**
 * Service ÒµÎñÂß¼­²ã
 * @author GuNiao
 *
 */
@Service
public class NewServiceImpl implements NewsService{
	@Autowired
	private NewsDao dao;

	public List<News> queryNewsByContent(String content) {
		if(content==null){
			content="";
		}
		return dao.queryNewsByContent(content);
	}

	public PageTools queryNewsByContent(String content, String curPage) {
		if(content==null){
			content="";
		}
		Integer curPageInt = 1;
		if(curPage!=null && curPage!=""){
			curPageInt=Integer.parseInt(curPage);
		}
		return dao.queryNewsByContent(content,curPageInt);
	}

	public void inserNews(String title,String content) {
		dao.inserNews(title, content);
	}
}
