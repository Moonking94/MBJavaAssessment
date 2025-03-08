package com.thirdparty.user.controller;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.thirdparty.user.constant.Constants;
import com.thirdparty.user.dto.BaseClassWrapper;
import com.thirdparty.user.dto.UserBean;
import com.thirdparty.user.dto.user.UserReqBean;
import com.thirdparty.user.dto.user.UserRespBean;
import com.thirdparty.user.dto.user.UserSearchBean;
import com.thirdparty.user.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired private IUserService service;
	
	@Autowired private Gson gson = new Gson();
	
	public UserController() {
	}
	
	/**
	* API for search
	**/
	@RequestMapping( value = { "searchAction" }, method = RequestMethod.GET)
	public BaseClassWrapper<UserRespBean> searchAction(
		    @RequestParam(required = false, name = "name") String name,
		    @RequestParam(required = false, name = "age") Integer age,
		    @RequestParam(required = false, name = "status") Character status,
		    @RequestParam(required = false, name = "createdDt") LocalDateTime createdDt,
		    @RequestParam(required = false, name = "modifiedDt") LocalDateTime modifiedDt,
		    @RequestParam(defaultValue = "0", name = "pageNumber") Integer pageNumber,
		    @RequestParam(defaultValue = "10", name = "rowPerPage") Integer rowPerPage, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<UserRespBean> wsRespBean = new BaseClassWrapper<UserRespBean>();
		UUID uuid = UUID.randomUUID();
		
		UserReqBean wsReqBean = new UserReqBean();
		UserSearchBean searchBean = new UserSearchBean();
	    UserBean parameterBean = new UserBean();

	    parameterBean.setName(name);
	    parameterBean.setAge(age);
	    parameterBean.setStatus(status);
	    parameterBean.setCreatedDt(createdDt);
	    parameterBean.setModifiedDt(modifiedDt);

	    searchBean.setParameterBean(parameterBean);
	    searchBean.setPageNumber(pageNumber);
	    searchBean.setRowPerPage(rowPerPage);

	    wsReqBean.setSearchBean(searchBean);

		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.searchAction(wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for create
	**/
	@RequestMapping( value = { "createAction" }, method = RequestMethod.POST)
	public BaseClassWrapper<UserRespBean> createAction(@RequestBody UserReqBean wsReqBean, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<UserRespBean> wsRespBean = new BaseClassWrapper<UserRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.createAction(wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for update
	**/
	@RequestMapping( value = { "updateAction/{id}" }, method = RequestMethod.PATCH)
	public BaseClassWrapper<UserRespBean> updateAction(@PathVariable("id") Long id, @RequestBody Map<String, Object> updatedFields, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<UserRespBean> wsRespBean = new BaseClassWrapper<UserRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(updatedFields)));
		
		wsRespBean = service.updateAction(id, updatedFields);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for retrieve by Id
	**/
	@RequestMapping( value = { "retrieveAction/id/{id}" }, method = RequestMethod.GET)
	public BaseClassWrapper<UserRespBean> retrieveAction(@PathVariable("id") Long id, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<UserRespBean> wsRespBean = new BaseClassWrapper<UserRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(id)));
		
		wsRespBean = service.retrieveAction(id);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for retrieve by email
	**/
	@RequestMapping( value = { "retrieveAction/email/{email}" }, method = RequestMethod.GET)
	public BaseClassWrapper<UserRespBean> retrieveUserByEmailAction(@PathVariable("email") String email, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<UserRespBean> wsRespBean = new BaseClassWrapper<UserRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(email)));
		
		wsRespBean = service.retrieveUserByEmailAction(email);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
}
