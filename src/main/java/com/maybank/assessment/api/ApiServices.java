package com.maybank.assessment.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maybank.assessment.api.dto.UserRespBean;
import com.maybank.assessment.constant.Constants;
import com.maybank.assessment.dto.BaseClassWrapper;

@Service
@Transactional
public class ApiServices {

	private final Logger logger = LoggerFactory.getLogger(ApiServices.class);
	
	@Autowired
	private Api api;
	
	public ApiServices() {
	}
	
	public UserRespBean getUserByEmail(String email){
		try {
			BaseClassWrapper<UserRespBean> response = api.getUserByEmail(email);
			
			if(response.getResponseCode().equals(Constants.RESPONSE_CODE_SUCCESS)) {
				return response.getResponseData();
			}
			
			return null;
		} catch (Exception e) {
			logger.error("Error getting user :: ", e);
			return null;
		}
	}
	
}
