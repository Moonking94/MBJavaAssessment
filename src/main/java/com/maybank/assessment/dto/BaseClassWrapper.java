package com.maybank.assessment.dto;

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
	public void setResponseSuccess(T responseData) {
		responseCode = Constants.RESPONSE_CODE_SUCCESS;
		responseMessage = "success";
		this.responseData = responseData;
	}
	
	// for default error
	public void setResponseError() {
		responseCode = Constants.RESPONSE_CODE_ERROR;
		responseMessage = "error";
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
