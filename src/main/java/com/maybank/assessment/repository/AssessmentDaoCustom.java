package com.maybank.assessment.repository;

import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.dto.assessment.AssessmentRespBean;

public interface AssessmentDaoCustom {

	public void clearEntityManagerCache();
	
	AssessmentRespBean search(AssessmentReqBean wsReqBean);
	
}
