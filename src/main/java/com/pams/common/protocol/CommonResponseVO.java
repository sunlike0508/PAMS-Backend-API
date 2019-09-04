package com.pams.common.protocol;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.ToString;

@ToString
@JsonInclude(Include.NON_NULL)
public class CommonResponseVO {
	private String responseCode;
	private String responseMessage;
	private Object responseData;
	private List<?> responseDataList;
	
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
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public List<?> getResponseDataList() {
		return responseDataList;
	}
	public void setResponseDataList(List<?> responseDataList) {
		this.responseDataList = responseDataList;
	}
}
