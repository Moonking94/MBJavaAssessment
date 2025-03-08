package com.thirdparty.user.dto.user;

import com.thirdparty.user.dto.CommonSearchBean;
import com.thirdparty.user.dto.UserBean;

public class UserSearchBean extends CommonSearchBean {

	private UserBean parameterBean = new UserBean();
	
	public UserSearchBean() {
	}

	public UserBean getParameterBean() {
		return parameterBean;
	}

	public void setParameterBean(UserBean parameterBean) {
		this.parameterBean = parameterBean;
	}
	
}
