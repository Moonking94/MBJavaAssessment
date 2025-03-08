package com.thirdparty.user.dto;

public class CommonSearchBean {

	private Integer pageNumber;
	
	private Integer rowPerPage;
	
	public CommonSearchBean() {
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(Integer rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
}
