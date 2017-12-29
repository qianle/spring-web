package cn.gn.web.service;

import java.util.List;

import cn.gn.web.bean.News;
import cn.gn.web.conf.PageTools;

public interface NewsService {
	/**
	 * �������� ģ����ѯ
	 * @param content ��������
	 * @return ���������б�
	 */
	public List<News> queryNewsByContent(String content);
	/**
	 * �������� ģ����ѯ ����ҳ
	 * @param content ��������
	 * @param curPage ��ǰҳ
	 * @return ���������б�
	 */
	public PageTools queryNewsByContent(String content,String curPage);
	
	public void inserNews(String title,String content);
}
