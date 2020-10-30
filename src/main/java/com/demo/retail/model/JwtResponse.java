package com.demo.retail.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}
