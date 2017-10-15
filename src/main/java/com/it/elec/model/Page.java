package com.it.elec.model;

public class Page {


	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public  int pageNumToIndex(String pageNum){
		
		index = (Integer.valueOf(pageNum)-1)*rows;
		return index;
	}
	
	/**当前页面首条数据位置*/
	private int index;
	
	public int getIndex() {
		return pageNumToIndex(this.pageNum);
	}
	public void setIndex(int index) {
		this.index = index;
	}

	/**当前页面数*/
	private String pageNum = "1";
	/**当前页面数据条数*/
	private int rows;
	private int totalNum;

	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
}
