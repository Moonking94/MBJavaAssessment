package com.maybank.assessment.service;

import java.util.Map;

import com.maybank.assessment.dto.BaseClassWrapper;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.dto.assessment.AssessmentRespBean;

public interface IAssessmentService {

	BaseClassWrapper<AssessmentRespBean> searchAction(AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> searchCountAction(AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> createAction(AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> updateAction(Long id, Map<String, Object> updatedFields);
	
	BaseClassWrapper<AssessmentRespBean> retrieveAction(Long id);
	
	BaseClassWrapper<AssessmentRespBean> deleteAction(Long id);
	
}
