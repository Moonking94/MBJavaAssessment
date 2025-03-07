package com.maybank.assessment.repository.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.repository.AbstractDao;
import com.maybank.assessment.repository.AssessmentDaoCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AssessmentDaoImpl extends AbstractDao implements AssessmentDaoCustom {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentDaoImpl.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	public AssessmentDaoImpl() {
	}
	
	@Override
	public Optional<List<AssessmentBean>> search(AssessmentReqBean wsReqBean) {
		return null;
	}
	
	@Override
	public Optional<List<AssessmentBean>> searchCount(AssessmentReqBean wsReqBean) {
		return null;
	}
	
}
