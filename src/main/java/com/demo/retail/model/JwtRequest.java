package com.demo.retail.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
}
