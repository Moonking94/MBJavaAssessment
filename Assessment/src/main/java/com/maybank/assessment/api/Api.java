package com.maybank.assessment.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maybank.assessment.api.dto.UserRespBean;
import com.maybank.assessment.dto.BaseClassWrapper;

@FeignClient(name = "thirdPartyApi", url = "${thirdparty.api.base-url}")
public interface Api {
	
    @GetMapping("/api/user/retrieveAction/email/{email}")
    BaseClassWrapper<UserRespBean> getUserByEmail(@PathVariable("email") String email);
    
}
