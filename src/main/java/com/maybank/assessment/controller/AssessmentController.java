package com.maybank.assessment.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.maybank.assessment.constant.Constants;
import com.maybank.assessment.dto.AssessmentReqBean;
import com.maybank.assessment.dto.AssessmentRespBean;
import com.maybank.assessment.dto.BaseClassWrapper;
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
	public BaseClassWrapper<AssessmentRespBean> updateAction(@PathVariable Long id, @RequestBody AssessmentReqBean wsReqBean, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.updateAction(id, wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for retrieve
	**/
	@RequestMapping( value = { "retrieveAction/{id}" }, method = RequestMethod.GET)
	public BaseClassWrapper<AssessmentRespBean> retrieveAction(@PathVariable Long id, @RequestBody AssessmentReqBean wsReqBean, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.retrieveAction(id, wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
	/**
	* API for delete
	**/
	@RequestMapping( value = { "deleteAction/{id}" }, method = RequestMethod.DELETE)
	public BaseClassWrapper<AssessmentRespBean> deleteAction(@PathVariable Long id, @RequestBody AssessmentReqBean wsReqBean, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		
		BaseClassWrapper<AssessmentRespBean> wsRespBean = new BaseClassWrapper<AssessmentRespBean>();
		UUID uuid = UUID.randomUUID();
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_REQUEST.replace("[string]", gson.toJson(wsReqBean)));
		
		wsRespBean = service.deleteAction(id, wsReqBean);
		
		logger.info((servletRequest.getServletPath() + " : [ID]").replace("ID", uuid.toString()) + " | " + Constants.FLAG_RESPONSE.replace("[string]", gson.toJson(wsRespBean)));
		
		return wsRespBean;
	}
	
}
