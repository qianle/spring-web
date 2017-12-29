package cn.gn.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;
import cn.gn.web.dao.NewsDao;

@Repository
public class NewsDaoImpl implements NewsDao {
	@Autowired
	private JdbcTemplate jdbc;

	public List<News> queryAll() {
		String sql = "select ntitle,ncontent from news ";
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		List<News> newsList = new ArrayList<News>();
		for (Map<String, Object> a : list) {
			String nTitle = (String) a.get("ntitle");
			String nContent = (String) a.get("ncontent");
			News news = new News();
			news.setnTitle(nTitle);
			news.setnContent(nContent);
			newsList.add(news);
		}
		return newsList;
	}

	public List<News> queryNewsByContent(String content) {

		String sql = "select ntitle,ncontent from news where ncontent like '%" + content + "%'";
		List<News> newsList = jdbc.query(sql, new RowMapper<News>() {

			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News();
				news.setnTitle(rs.getString("ntitle"));
				news.setnContent(rs.getString("ncontent"));
				return news;
			}

		});
		/*
		 * List<Map<String, Object>> list = jdbc.queryForList(sql); List<News>
		 * newsList = new ArrayList<News>(); for(Map<String, Object> a:list){
		 * String nTitle =(String) a.get("ntitle"); String nContent =(String)
		 * a.get("ncontent"); News news = new News(); news.setnTitle(nTitle);
		 * news.setnContent(nContent); newsList.add(news); }
		 */
		return newsList;
	}

	public Integer getTableListCount(String content) {
		// 定义要执行的 查询数据库总记录数sql
		String sql = "select count(nid) as rn  from news  where ncontent like '%" + content + "%'";
		List<Map<String, Object>> arr = jdbc.queryForList(sql);
		return Integer.parseInt(arr.get(0).get("RN").toString());
	}

	public PageTools queryNewsByContent(String content, Integer curPage) {
		// 获取总记录数
		Integer totalCount = getTableListCount(content);
		// 传入当前页 ,总记录数 计算分页逻辑
		PageTools pTools = new PageTools(curPage, null, totalCount);
		String sql = "select * from news where ncontent like '%"+content+"%' limit "+pTools.getStaIndex()+","+pTools.getEndIndex();
		System.out.println(sql);
		List<News> newsList = jdbc.query(sql, new RowMapper<News>() {

			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News();
				news.setnTitle(rs.getString("ntitle"));
				news.setnContent(rs.getString("ncontent"));
				return news;
			}

		});
		pTools.setData(newsList);
		return pTools;
	}

	public void inserNews(String title, String content) {
		String sql = "insert into news(ntitle,ncontent) values('"+title+"','"+content+"')";
		System.out.println(sql);
		jdbc.execute(sql);
		
	}

}
