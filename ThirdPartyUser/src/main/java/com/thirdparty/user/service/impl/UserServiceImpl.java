package com.thirdparty.user.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdparty.user.constant.Constants;
import com.thirdparty.user.dto.BaseClassWrapper;
import com.thirdparty.user.dto.UserBean;
import com.thirdparty.user.dto.user.UserReqBean;
import com.thirdparty.user.dto.user.UserRespBean;
import com.thirdparty.user.model.UserEntity;
import com.thirdparty.user.repository.UserDao;
import com.thirdparty.user.service.AbstractService;
import com.thirdparty.user.service.IUserService;

@Service
public class UserServiceImpl extends AbstractService implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired private UserDao dao;
	
	@Autowired private MessageSource messageSource;
	
	@Override
	@Transactional(readOnly = true)
	public BaseClassWrapper<UserRespBean> searchAction(UserReqBean wsReqBean) {
		BaseClassWrapper<UserRespBean> response = new BaseClassWrapper<UserRespBean>();
		
		UserRespBean responseData = dao.search(wsReqBean);
		
		response.setResponseSuccess(messageSource, responseData);
		
		return response;
	}
	
	@Override
	@Transactional
	public BaseClassWrapper<UserRespBean> createAction(UserReqBean wsReqBean) {
		
		BaseClassWrapper<UserRespBean> response = new BaseClassWrapper<UserRespBean>();
		
		if(wsReqBean == null || wsReqBean.getBean() == null) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_EMPTY_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		UserBean bean = wsReqBean.getBean();
		
		if(bean.getId() != null) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_BAD_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		} else if(bean.getEmail() == null) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_BAD_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		try {
			UserEntity ent = new UserEntity();
			ent.toEntity(wsReqBean.getBean());
			
			ent.setCreatedDt(LocalDateTime.now());
	
			ent = dao.saveAndFlush(ent);
			dao.clearEntityManagerCache();
			
			ent = dao.findById(ent.getId()).get();
			UserBean tmpBean = new UserBean();
			tmpBean.toBean(ent);
			
			UserRespBean responseData = new UserRespBean();
			responseData.setBean(tmpBean);
			response.setResponseSuccess(messageSource, responseData);
		} catch(Exception e) {
			logger.error("Error while saving :: ", e);
			response.setResponseError(e.getMessage());
			return response;
		}
		
		return response;
	}

	@Override
	@Transactional
	public BaseClassWrapper<UserRespBean> updateAction(Long id, Map<String, Object> updatedFields) {
		BaseClassWrapper<UserRespBean> response = new BaseClassWrapper<UserRespBean>();
		
		if(id == null || updatedFields == null || updatedFields.isEmpty()) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_EMPTY_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		Optional<UserEntity> existingEntity = dao.findById(id);
		if(existingEntity.isEmpty()) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_RECORD_NOT_FOUND, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		try {
		    AtomicReference<UserEntity> entRef = new AtomicReference<>(existingEntity.get());
	
		    updatedFields.forEach((key, value) -> setField(entRef.get(), key, value));
	
		    UserEntity ent = entRef.get();
		    ent.setModifiedDt(LocalDateTime.now());
		    
		    ent = dao.saveAndFlush(entRef.get());
	        dao.clearEntityManagerCache();
			
			ent = dao.findById(ent.getId()).get();
			UserBean bean = new UserBean();
			bean.toBean(ent);
	        
			UserRespBean responseData = new UserRespBean();
			responseData.setBean(bean);
			response.setResponseSuccess(messageSource, responseData);
		} catch(Exception e) {
			logger.error("Error while updating :: ", e);
			response.setResponseError(e.getMessage());
		}
		
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public BaseClassWrapper<UserRespBean> retrieveAction(Long id) {
		BaseClassWrapper<UserRespBean> response = new BaseClassWrapper<UserRespBean>();
		
		if(id == null) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_BAD_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		Optional<UserEntity> entOpt = dao.findById(id);
		
		if(entOpt.isEmpty()) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_RECORD_NOT_FOUND, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		UserEntity ent = entOpt.get();
		UserBean bean = new UserBean();
		bean.toBean(ent);
		
		UserRespBean responseData = new UserRespBean();
		responseData.setBean(bean);
		response.setResponseSuccess(messageSource, responseData);
		
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public BaseClassWrapper<UserRespBean> retrieveUserByEmailAction(String email) {
		BaseClassWrapper<UserRespBean> response = new BaseClassWrapper<UserRespBean>();
		
		if(email == null) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_BAD_REQUEST, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		Optional<UserEntity> entOpt = dao.findByEmail(email);
		
		if(entOpt.isEmpty()) {
			response.setResponseError(messageSource.getMessage(Constants.ERROR_RECORD_NOT_FOUND, null, LocaleContextHolder.getLocale()));
			logger.info(response.getResponseMessage());
			
			return response;
		}
		
		UserEntity ent = entOpt.get();
		UserBean bean = new UserBean();
		bean.toBean(ent);
		
		UserRespBean responseData = new UserRespBean();
		responseData.setBean(bean);
		response.setResponseSuccess(messageSource, responseData);
		
		return response;
	}
}
