package com.thirdparty.user.dto.user;

import com.thirdparty.user.dto.UserBean;

public class UserReqBean {

	private UserSearchBean searchBean = new UserSearchBean();
	
	private UserBean bean = new UserBean();
	
	public UserReqBean() {
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

}
