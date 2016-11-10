package com.study.myhome.common.util;

import java.util.List;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public class ListObjectImpl<T> implements ListObject<T> {

	private List<T> list;

	private int totalCnt;

	private PaginationInfo paginationInfo;

	public ListObjectImpl(List<T> list, int totalCnt) {
		super();
		this.list = list;
		this.totalCnt = totalCnt;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		if(paginationInfo != null) {
			// 페이징 값 계산
			paginationInfo.setTotalRecordCount(this.totalCnt);
			this.paginationInfo = paginationInfo;
		}
	}
}
