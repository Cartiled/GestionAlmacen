package com.project.almacen.cmmon;

import java.util.HashMap;

public class QueryPageParam {
	
	private static int PAGE_SIZE = 20;
	private static int PAGE_NUM = 1;
	
	@SuppressWarnings("rawtypes")
	private HashMap param = new HashMap();
	
	private int pageSize = PAGE_SIZE;
	private int pageNum = PAGE_NUM;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public HashMap getParam() {
		return param;
	}
	public void setParam(HashMap param) {
		this.param = param;
	}
	
	
	
}
