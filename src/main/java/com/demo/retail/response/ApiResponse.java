package com.demo.retail.response;

import com.demo.retail.constants.ApiResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class  ApiResponse{

	private ApiResponseStatus status;

	public ApiResponse(ApiResponseStatus status) {
		this.status = status;
	}
}
