package com.maybank.assessment.service.impl;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maybank.assessment.dto.AssessmentBean;
import com.maybank.assessment.dto.BaseClassWrapper;
import com.maybank.assessment.dto.assessment.AssessmentReqBean;
import com.maybank.assessment.dto.assessment.AssessmentRespBean;
import com.maybank.assessment.model.AssessmentEntity;
import com.maybank.assessment.repository.AssessmentDao;
import com.maybank.assessment.service.AbstractService;
import com.maybank.assessment.service.IAssessmentService;

@Service
@Transactional
public class AssessmentServiceImpl extends AbstractService implements IAssessmentService {

	private static final Logger logger = LoggerFactory.getLogger(AssessmentServiceImpl.class);
	
	@Autowired private AssessmentDao dao;
	
	@Override
	public BaseClassWrapper<AssessmentRespBean> searchAction(AssessmentReqBean wsReqBean) {
		return null;
	}
	
	@Override
	public BaseClassWrapper<AssessmentRespBean> createAction(AssessmentReqBean wsReqBean) {
		
		BaseClassWrapper<AssessmentRespBean> response = new BaseClassWrapper<AssessmentRespBean>();
		
		if(wsReqBean == null || wsReqBean.getBean() == null) {
			response.setResponseError("Empty request");
			logger.info("Empty request");
			
			return response;
		} else if(wsReqBean.getBean().getId() != null) {
			response.setResponseError("Bad Request");
			logger.info("Bad Request");
			
			return response;
		}
		
		try {
			AssessmentEntity ent = new AssessmentEntity();
			ent.toEntity(wsReqBean.getBean());
			
			ent.setCreatedDt(Instant.now());
			
			ent = dao.saveAndFlush(ent);
			dao.clearEntityManagerCache();
			
			ent = dao.findById(ent.getId()).get();
			AssessmentBean bean = new AssessmentBean();
			bean.toBean(ent);
			
			AssessmentRespBean responseData = new AssessmentRespBean();
			responseData.setBean(bean);
			response.setResponseSuccess(responseData);
		} catch(Exception e) {
			logger.error("Error while saving");
			response.setResponseError(e.getMessage());
		}
		
		return response;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> updateAction(Long id, Map<String, Object> updatedFields) {
		BaseClassWrapper<AssessmentRespBean> response = new BaseClassWrapper<AssessmentRespBean>();
		
		if(id == null || updatedFields == null || updatedFields.isEmpty()) {
			response.setResponseError("Empty request");
			logger.info("Empty request");
			
			return response;
		}
		
		Optional<AssessmentEntity> existingEntity = dao.findById(id);
		if(existingEntity.isEmpty()) {
			response.setResponseError("ID not found");
			logger.info("ID not found");
			
			return response;
		}
		
	    AtomicReference<AssessmentEntity> entRef = new AtomicReference<>(existingEntity.get());

	    updatedFields.forEach((key, value) -> setField(entRef.get(), key, value));

	    AssessmentEntity ent = entRef.get();
	    ent.setModifiedDt(Instant.now());
	    
	    ent = dao.saveAndFlush(entRef.get());
        dao.clearEntityManagerCache();
		
		ent = dao.findById(ent.getId()).get();
		AssessmentBean bean = new AssessmentBean();
		bean.toBean(ent);
        
		AssessmentRespBean responseData = new AssessmentRespBean();
		responseData.setBean(bean);
		response.setResponseSuccess(responseData);
		
		return response;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> retrieveAction(Long id) {
		BaseClassWrapper<AssessmentRespBean> response = new BaseClassWrapper<AssessmentRespBean>();
		
		if(id == null) {
			response.setResponseError("Empty request");
			logger.info("Empty request");
			
			return response;
		}
		
		Optional<AssessmentEntity> entOpt = dao.findById(id);
		
		if(entOpt.isEmpty()) {
			response.setResponseError("Record not found");
			logger.info("Record not found");
			
			return response;
		}
		
		AssessmentEntity ent = entOpt.get();
		AssessmentBean bean = new AssessmentBean();
		bean.toBean(ent);
		
		AssessmentRespBean responseData = new AssessmentRespBean();
		responseData.setBean(bean);
		response.setResponseSuccess(responseData);
		
		return response;
	}

	@Override
	public BaseClassWrapper<AssessmentRespBean> deleteAction(Long id) {
		BaseClassWrapper<AssessmentRespBean> response = new BaseClassWrapper<AssessmentRespBean>();
		
		if(id == null) {
			response.setResponseError("Empty request");
			logger.info("Empty request");
			
			return response;
		}
		
		Optional<AssessmentEntity> entOpt = dao.findById(id);
		
		if(entOpt.isEmpty()) {
			response.setResponseError("Record not found");
			logger.info("Record not found");
			
			return response;
		}
		
		dao.deleteById(entOpt.get().getId());
		
		response.setResponseSuccess(null);
		
		return response;
	}

}
