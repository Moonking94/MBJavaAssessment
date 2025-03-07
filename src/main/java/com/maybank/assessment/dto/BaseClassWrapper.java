package com.maybank.assessment.dto;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.maybank.assessment.constant.Constants;

public class BaseClassWrapper<T> {

	private String responseCode;
	
	private String responseMessage;
	
	private T responseData;

	public BaseClassWrapper() {
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
	
	// to set success
	public void setResponseSuccess(MessageSource messageSource, T responseData) {
		responseCode = Constants.RESPONSE_CODE_SUCCESS;
		responseMessage = messageSource.getMessage(Constants.LBL_RESPONSE_CODE + Constants.RESPONSE_CODE_SUCCESS, null, LocaleContextHolder.getLocale());
		this.responseData = responseData;
	}
	
	// for default error
	public void setResponseError(MessageSource messageSource) {
		responseCode = Constants.RESPONSE_CODE_ERROR;
		responseMessage = messageSource.getMessage(Constants.LBL_RESPONSE_CODE + Constants.RESPONSE_CODE_ERROR, null, LocaleContextHolder.getLocale());
	}
	
	// for custom message with error
	public void setResponseError(String responseMessage) {
		responseCode = Constants.RESPONSE_CODE_ERROR;
		this.responseMessage = responseMessage;
	}
	
	// for custom response error
	public void setResponseError(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	// for custom response
	public void setResponseCodeValue(String responseCode, String responseMessage, T responseData) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.responseData = responseData;
	}
}
