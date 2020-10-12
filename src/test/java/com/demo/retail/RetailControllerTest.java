package com.demo.retail;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.retail.controller.RateController;
import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.mapper.RateEntityMapper;
import com.demo.retail.request.RateRequest;
import com.demo.retail.response.RateResponse;
import com.demo.retail.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(controllers = RateController.class)
public class RetailControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RateService rateService;

	@MockBean
	private RateEntityMapper mapper;

	@Test
	public void shouldReturn404WhenFIndUserById() {
		
		final long userId=1L;
		given(rateService.find(userId)).willReturn(Optional.empty());
		mockMvc.perform(get("get/{id}", -1L)).andExpect(status().isNotFound());
		
	}
	
	@Test
	public void shouldGetRate() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		given(rateService.find(1L)).thenReturn(entityOptional);
		given(mapper.execute(entity)).thenReturn(new RateResponse("success"));
		mockMvc.perform(get("get/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAdd() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		given(mapper.execute(new RateRequest())).thenReturn(entity);
		given(rateService.add(entity)).thenReturn(entityOptional);
		mockMvc.perform(get("/surcharge/get/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldGetUpddate() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		given(rateService.find(1L)).thenReturn(entityOptional);
		given(rateService.add(entity)).thenReturn(entityOptional);
		mockMvc.perform(get("/surcharge/update/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldGetDelete() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		given(rateService.find(1L)).thenReturn(entityOptional);
		given(mapper.execute(entity)).thenReturn(new RateResponse("success"));
		mockMvc.perform(get("/surchare/get/{id}", 1L)).andExpect(status().isOk());
	}
}
