package com.demo.retail.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}
