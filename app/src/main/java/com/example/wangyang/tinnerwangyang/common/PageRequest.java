package com.example.wangyang.tinnerwangyang.common;

public class PageRequest {
	private int startIndex;
	private int pageSize ;
	private long sortId  ;
	private int loadType;
	private int page;

	public PageRequest(int start, int pageSize) {
		super();
		this.startIndex = start;
		this.pageSize = pageSize;
	}
	
	public int getStart() {
		return startIndex;
	}
	public void setStart(int start) {
		this.startIndex = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public long getSortId() {
		return sortId;
	}

	public void setSortId(long sortId) {
		this.sortId = sortId;
	}

	public int getLoadType() {
		return loadType;
	}

	public void setLoadType(int loadType) {
		this.loadType = loadType;
	}

}
