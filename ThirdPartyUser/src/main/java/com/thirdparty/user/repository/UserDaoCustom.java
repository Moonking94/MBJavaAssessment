package com.thirdparty.user.repository;

import com.thirdparty.user.dto.user.UserReqBean;
import com.thirdparty.user.dto.user.UserRespBean;

public interface UserDaoCustom {

	public void clearEntityManagerCache();
	
	UserRespBean search(UserReqBean wsReqBean);
	
}
