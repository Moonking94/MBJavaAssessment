package com.maybank.assessment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maybank.assessment.dto.AssessmentReqBean;
import com.maybank.assessment.dto.AssessmentRespBean;
import com.maybank.assessment.dto.BaseClassWrapper;
import com.maybank.assessment.service.IAssessmentService;

@Service
@Transactional
public class AssessmentServiceImpl implements IAssessmentService {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentServiceImpl.class);
	
	@Override
	public BaseClassWrapper<AssessmentRespBean> createAction(AssessmentReqBean wsReqBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> updateAction(Long id, AssessmentReqBean wsReqBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> retrieveAction(Long id, AssessmentReqBean wsReqBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> deleteAction(Long id, AssessmentReqBean wsReqBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
