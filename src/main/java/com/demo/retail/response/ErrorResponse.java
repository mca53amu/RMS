package com.demo.retail.response;

import java.util.List;

import com.demo.retail.constants.ApiResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value=Include.NON_NULL)
public class ErrorResponse extends ApiResponse {
	private String errorCode;

	private List<FieldError> errors;
	
	private String trackingId;

	public ErrorResponse(String errorCode, String trackingId,List<FieldError> errors) {
		super(ApiResponseStatus.FAIL);
		this.errorCode = errorCode;
		this.errors = errors;
		this.trackingId=trackingId;
	}
	

	public ErrorResponse(String errorCode, String trackingId) {
		super(ApiResponseStatus.FAIL);
		this.errorCode = errorCode;
		this.trackingId=trackingId;
	}

}
