package com.demo.retail.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldError {

	private String name;
	private String message;

	public FieldError(String field, String defaultMessage) {
		this.name=field;
		this.message=defaultMessage;
	}

}
