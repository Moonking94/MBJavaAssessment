package com.maybank.assessment.dto;

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
	
}
