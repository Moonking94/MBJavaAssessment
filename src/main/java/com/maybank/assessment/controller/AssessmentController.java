package com.maybank.assessment.controller;

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
import com.maybank.assessment.constant.Constants;
import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.BaseClassWrapper;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.dto.assessment.AssessmentRespBean;
import com.maybank.assessment.dto.assessment.AssessmentSearchBean;
import com.maybank.assessment.service.IAssessmentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/assessment")
public class AssessmentController {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentController.class);
	
	@Autowired private IAssessmentService service;
	
	@Autowired private Gson gson = new Gson();
	
	public AssessmentController() {
	}
	
	/**
	* API for search
	**/
	@RequestMapping( value = { "searchAction" }, method = RequestMethod.GET)
	public BaseClassWrapper<AssessmentRespBean> searchAction(
		    @RequestParam(required = false, name = "name") String name,
		    @RequestParam(required = false, name = "age") Integer age,
		    @RequestParam(required = false, name = "address") String address,
		    @RequestParam(required = false, name = "city") String city,
		    @RequestParam(required = false, name = "postcode") String postcode,
		    @RequestParam(required = false, name = "stateId") Integer stateId,
		    @RequestParam(required = false, name = "status") Character status,
		    @RequestParam(required = false, name = "createdDt") LocalDateTime createdDt,
		    @RequestParam(required = false, name = "modifiedDt") LocalDateTime modifiedDt,
		    @RequestParam(defaultValue = "0", name = "pageNumber") Integer pageNumber,
		    @RequestParam(defaultValue = "10", name = "rowPerPage") Integer rowPerPage, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		AssessmentReqBean wsReqBean = new AssessmentReqBean();
		AssessmentSearchBean searchBean = new AssessmentSearchBean();
	    AssessmentBean parameterBean = new AssessmentBean();

	    parameterBean.setName(name);
	    parameterBean.setAge(age);
	    parameterBean.setAddress(address);
	    parameterBean.setCity(city);
	    parameterBean.setPostcode(postcode);
	    parameterBean.setStateId(stateId);
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
	* API for search count
	**/
	@RequestMapping( value = { "searchCountAction" }, method = RequestMethod.GET)
	public BaseClassWrapper<AssessmentRespBean> searchCountAction(
			@RequestParam(required = false, name = "name") String name,
		    @RequestParam(required = false, name = "age") Integer age,
		    @RequestParam(required = false, name = "address") String address,
		    @RequestParam(required = false, name = "city") String city,
		    @RequestParam(required = false, name = "postcode") String postcode,
		    @RequestParam(required = false, name = "stateId") Integer stateId,
		    @RequestParam(required = false, name = "status") Character status,
		    @RequestParam(required = false, name = "createdDt") LocalDateTime createdDt,
		    @RequestParam(required = false, name = "modifiedDt") LocalDateTime modifiedDt,
		    @RequestParam(defaultValue = "0", name = "pageNumber") Integer pageNumber,
		    @RequestParam(defaultValue = "10", name = "rowPerPage") Integer rowPerPage, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		AssessmentReqBean wsReqBean = new AssessmentReqBean();
	    AssessmentSearchBean searchBean = new AssessmentSearchBean();
	    AssessmentBean parameterBean = new AssessmentBean();

	    parameterBean.setName(name);
	    parameterBean.setAge(age);
	    parameterBean.setAddress(address);
	    parameterBean.setCity(city);
	    parameterBean.setPostcode(postcode);
	    parameterBean.setStateId(stateId);
	    parameterBean.setStatus(status);
	    parameterBean.setCreatedDt(createdDt);
	    parameterBean.setModifiedDt(modifiedDt);

	    searchBean.setParameterBean(parameterBean);
	    searchBean.setPageNumber(pageNumber);
	    searchBean.setRowPerPage(rowPerPage);

	    wsReqBean.setSearchBean(searchBean);

		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.searchCountAction(wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for create
	**/
	@RequestMapping( value = { "createAction" }, method = RequestMethod.POST)
	public BaseClassWrapper<AssessmentRespBean> createAction(@RequestBody AssessmentReqBean wsReqBean, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
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
	public BaseClassWrapper<AssessmentRespBean> updateAction(@PathVariable("id") Long id, @RequestBody Map<String, Object> updatedFields, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(updatedFields)));
		
		wsRespBean = service.updateAction(id, updatedFields);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for retrieve
	**/
	@RequestMapping( value = { "retrieveAction/{id}" }, method = RequestMethod.GET)
	public BaseClassWrapper<AssessmentRespBean> retrieveAction(@PathVariable("id") Long id, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(id)));
		
		wsRespBean = service.retrieveAction(id);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for delete
	**/
	@RequestMapping( value = { "deleteAction/{id}" }, method = RequestMethod.DELETE)
	public BaseClassWrapper<AssessmentRespBean> deleteAction(@PathVariable("id") Long id, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(id)));
		
		wsRespBean = service.deleteAction(id);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
}
