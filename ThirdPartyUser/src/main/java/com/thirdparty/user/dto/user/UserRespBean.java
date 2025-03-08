package com.thirdparty.user.dto.user;

import java.util.List;

import com.thirdparty.user.dto.UserBean;

public class UserRespBean {

	private UserSearchBean searchBean = new UserSearchBean();
	
	private UserBean bean = new UserBean();
	
	private List<UserBean> searchResults;
	
	private Long totalCount;
	
	public UserRespBean() {
	}

	public UserSearchBean getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(UserSearchBean searchBean) {
		this.searchBean = searchBean;
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
