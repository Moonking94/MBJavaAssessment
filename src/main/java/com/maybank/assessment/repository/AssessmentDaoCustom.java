package com.maybank.assessment.repository;

import java.util.List;
import java.util.Optional;

import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;

public interface AssessmentDaoCustom {

	public void clearEntityManagerCache();
	
	Optional<List<AssessmentBean>> search(AssessmentReqBean wsReqBean);
	
	Optional<List<AssessmentBean>> searchCount(AssessmentReqBean wsReqBean);
	
}
