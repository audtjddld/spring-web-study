package com.study.myhome.common.util;

import java.util.List;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public interface ListObject <T> {
	public void setPaginationInfo(PaginationInfo paginationInfo);
	
	public List<T> getList();
	
	public PaginationInfo getPaginationInfo();
}
