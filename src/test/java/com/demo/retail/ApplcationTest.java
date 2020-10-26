package com.demo.retail;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

import com.demo.retail.controller.JWTAuthController;
import com.demo.retail.util.jwt.JWTUserDetailsService;
import com.demo.retail.util.jwt.JwtTokenUtil;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ApplcationTest {
	
	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private JwtTokenUtil jwtTokenUtil;

	@Mock
	private JWTUserDetailsService userDetailsService;
	@InjectMocks
	private JWTAuthController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
