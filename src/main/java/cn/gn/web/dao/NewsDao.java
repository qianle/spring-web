package cn.gn.web.dao;

import java.sql.SQLException;
import java.util.List;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;
/**
 * 
 * @author GuNiao 1835376491@qq.com
 *
 */
public interface NewsDao {
	/**
	 * 查询所有新闻  (只会查询前100条)
	 * @return 返回新闻列表
	 */
	public List<News> queryAll();
	/**
	 * 根据内容 模糊查询
	 * @param content 新闻内容
	 * @return 返回新闻列表
	 */
	public List<News> queryNewsByContent(String content);
	/**
	 * 查询数据库总记录数
	 * @param name 查询条件
	 * @return
	 */
	public Integer getTableListCount(String name);
	
	/**
	 * 根据内容 模糊查询 并分页
	 * @param content 新闻内容
	 * @param curPage 当前页
	 * @return
	 */
	public PageTools queryNewsByContent(String content,Integer curPage);
	
	public void inserNews(String title,String content);
		
		
}
