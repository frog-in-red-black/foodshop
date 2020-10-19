package com.study.util;

import java.util.List;

public class Page<T> {
	
	private List<T> list;
	
	private int totalCount;
	
	private int totalPage;
	
	private int currentPage;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Page(List<T> list, int totalCount, int totalPage, int currentPage) {
		super();
		this.list = list;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}

	public Page() {
		super();
	}

	@Override
	public String toString() {
		return "Page [list=" + list + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage="
				+ currentPage + "]";
	}
	
	

}
