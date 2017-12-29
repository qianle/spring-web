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
	 * ��ѯ��������  (ֻ���ѯǰ100��)
	 * @return ���������б�
	 */
	public List<News> queryAll();
	/**
	 * �������� ģ����ѯ
	 * @param content ��������
	 * @return ���������б�
	 */
	public List<News> queryNewsByContent(String content);
	/**
	 * ��ѯ���ݿ��ܼ�¼��
	 * @param name ��ѯ����
	 * @return
	 */
	public Integer getTableListCount(String name);
	
	/**
	 * �������� ģ����ѯ ����ҳ
	 * @param content ��������
	 * @param curPage ��ǰҳ
	 * @return
	 */
	public PageTools queryNewsByContent(String content,Integer curPage);
	
	public void inserNews(String title,String content);
		
		
}
