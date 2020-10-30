package com.demo.retail.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RateError{

	private String errorCode;
	
	private String errorMessage;
	
	
}
