package com.maybank.assessment.api.dto;

import java.util.List;

public class UserRespBean {

	private UserBean bean = new UserBean();
	
	private List<UserBean> searchResults;
	
	private Long totalCount;
	
	public UserRespBean() {
	}

	public UserBean getBean() {
		return bean;
	}

	public void setBean(UserBean bean) {
		this.bean = bean;
	}

	public List<UserBean> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<UserBean> searchResults) {
		this.searchResults = searchResults;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	
}
