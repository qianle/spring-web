package cn.gn.web.conf;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.gn.web.bean.News;

/**
 * ��ҳ����
 * @author GuNiao
 *
 */
public class PageTools {
	/**
	 * �����
	 * @param curPage
	 * @param pageCount
	 * @param totalCount
	 */
	public PageTools(Integer curPage, Integer pageCount,Integer totalCount) {
		this.curPage = curPage;
		this.pageCount = (pageCount==null?this.pageCount:pageCount);
		this.totalCount = totalCount;
		this.prePage = (curPage==1?1:curPage-1);
		this.totalPage = (totalCount%this.pageCount==0?totalCount/this.pageCount:totalCount/this.pageCount+1);
		this.nextPage = (curPage==totalPage?totalPage:curPage+1);
		this.staIndex = (curPage-1)*this.pageCount+1;
		this.endIndex = curPage*this.pageCount;
	}
	/**
	 * ��ǰҳ
	 */
	private Integer curPage;
	/**
	 * ÿҳ��ʾ������
	 */
	private Integer pageCount=10;
	/**
	 * ��һҳ
	 */
	private Integer prePage;
	/**
	 * ��һҳ
	 */
	private Integer nextPage;
	/**
	 * ��ҳ��
	 */
	private Integer totalPage;
	/**
	 * �ܼ�¼�� (�����ݿ��ж���������)
	 */
	private  Integer totalCount;
	/**
	 * ��ʼ����
	 */
	private Integer staIndex;
	/**
	 * ��������
	 */
	private Integer endIndex;
	
	@Autowired
	private List<News> data;
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getStaIndex() {
		return staIndex;
	}
	public void setStaIndex(Integer staIndex) {
		this.staIndex = staIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}
	public static void main(String[] args) {
		PageTools pTools = new PageTools(2, null, 20);
		System.out.println(pTools.getCurPage());
		System.out.println(pTools.getPrePage());
		System.out.println(pTools.getNextPage());
		System.out.println(pTools.getPageCount());
		System.out.println(pTools.getTotalPage());
		System.out.println(pTools.getStaIndex());
		System.out.println(pTools.getEndIndex());
	}
	
}
