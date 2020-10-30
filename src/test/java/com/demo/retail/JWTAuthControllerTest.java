package com.demo.retail;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.retail.model.JwtRequest;
import com.demo.retail.util.jwt.JWTUserDetailsService;
import com.demo.retail.util.jwt.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class JWTAuthControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private AuthenticationManager authenticationManager;

	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	@MockBean
	private JWTUserDetailsService userDetailsService;

	@Test
	public void test() throws Exception {

		JwtRequest authenticationRequest = getJwtRequest();
		Mockito.when(userDetailsService.loadUserByUsername(authenticationRequest.getUsername())).thenReturn(getUser());
		Mockito.when(jwtTokenUtil.generateToken(getUser())).thenReturn(
				"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE2MDQwNjEyMTAsImlhdCI6MTYwNDA0MzIxMH0.Ggv43XkG3_hfhFTZ3BiUQCfqJ2CueROVEW-ztVY31D6Gv1AAT2PxREKtneQtiIU3yaQ5u2-7nPFqljcIgzUzZA");
		mvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(authenticationRequest))).andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("SUCCESS")));
	}

	private JwtRequest getJwtRequest() {
		JwtRequest requestObject = new JwtRequest();
		requestObject.setUsername("javainuse");
		requestObject.setPassword("password");
		return requestObject;
	}

	private User getUser() {
		return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
