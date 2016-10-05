package com.study.myhome.common.service;


public class Pageable {
	// 페이지 인덱스
	private int p = 1;
	
	// 페이지 갯수
	private int PageUnit = 10;
	
	// 페이지당 게시물 수
	private int pageSize = 10;

	// 첫 페이징
	private int firstIndex;
	
	// 마지막 페이징
	private int lastIndex;
	
	// 페이지 당 갯수
	private int recordCountPerPage = 10;
	
	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPageUnit() {
		return PageUnit;
	}

	public void setPageUnit(int pageUnit) {
		PageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
    public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

}
