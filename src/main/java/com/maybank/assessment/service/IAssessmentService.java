package com.maybank.assessment.service;

import com.maybank.assessment.dto.AssessmentReqBean;
import com.maybank.assessment.dto.AssessmentRespBean;
import com.maybank.assessment.dto.BaseClassWrapper;

public interface IAssessmentService {

	BaseClassWrapper<AssessmentRespBean> createAction(AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> updateAction(Long id, AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> retrieveAction(Long id, AssessmentReqBean wsReqBean);
	
	BaseClassWrapper<AssessmentRespBean> deleteAction(Long id, AssessmentReqBean wsReqBean);
	
}
