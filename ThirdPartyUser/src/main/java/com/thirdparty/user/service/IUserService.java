package com.thirdparty.user.service;

import java.util.Map;

import com.thirdparty.user.dto.BaseClassWrapper;
import com.thirdparty.user.dto.user.UserReqBean;
import com.thirdparty.user.dto.user.UserRespBean;

public interface IUserService {

	BaseClassWrapper<UserRespBean> searchAction(UserReqBean wsReqBean);
	
	BaseClassWrapper<UserRespBean> createAction(UserReqBean wsReqBean);
	
	BaseClassWrapper<UserRespBean> updateAction(Long id, Map<String, Object> updatedFields);
	
	BaseClassWrapper<UserRespBean> retrieveAction(Long id);
	
	BaseClassWrapper<UserRespBean> retrieveUserByEmailAction(String email);
	
}
