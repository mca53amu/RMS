package com.demo.retail.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

	private String message;

	public ApiException(Throwable t) {
		this.message= t.getMessage();
	}
	
	public ApiException(String message) {
		this.message=message;
	}
}
