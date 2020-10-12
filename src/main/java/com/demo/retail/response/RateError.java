package com.demo.retail.response;

import com.demo.retail.constants.ApiResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateError extends ApiResponse{

	private String message;
	public RateError(String message,ApiResponseStatus status) {
		super(status);
		this.message = message;
	}
}
