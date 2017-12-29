package cn.gn.web.service;

import java.util.List;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;

public interface NewsService {
	/**
	 * 根据内容 模糊查询
	 * @param content 新闻内容
	 * @return 返回新闻列表
	 */
	public List<News> queryNewsByContent(String content);
	/**
	 * 根据内容 模糊查询 并分页
	 * @param content 新闻内容
	 * @param curPage 当前页
	 * @return 返回新闻列表
	 */
	public PageTools queryNewsByContent(String content,String curPage);
	
	public void inserNews(String title,String content);
}
