package com.demo.retail.model;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.response.ApiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse extends ApiResponse{
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		super(ApiResponseStatus.SUCCESS);
		this.jwttoken = jwttoken;
	}
}
