package com.demo.retail.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateException extends RuntimeException {

	private String message;

	public RateException(Throwable t) {
		this.message= t.getMessage();
	}
	
	public RateException(String message) {
		this.message=message;
	}
}
