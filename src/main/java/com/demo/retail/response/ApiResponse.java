package com.demo.retail.response;

import com.demo.retail.constants.ApiResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

	private ApiResponseStatus status;
	private T response;

	public ApiResponse(ApiResponseStatus status, T response) {
		this.status = status;
		this.response = response;
	}

	public ApiResponse(ApiResponseStatus status) {
		this.status=status;
	}

}
