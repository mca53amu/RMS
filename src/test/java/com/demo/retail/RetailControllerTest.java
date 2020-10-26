package com.demo.retail;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.controller.RateController;
import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.mapper.RateEntityMapper;
import com.demo.retail.request.RateRequest;
import com.demo.retail.response.ApiResponse;
import com.demo.retail.service.RateService;
@WebMvcTest(controllers = RateController.class)
public class RetailControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RateService rateService;

	@MockBean
	private RateEntityMapper mapper;

	@Test
	public void shouldReturn404WhenFIndUserById() throws Exception {
		
		final long userId=1L;
		when(rateService.find(userId)).thenReturn((Optional.empty()));
		mockMvc.perform(get("get/{id}", -1L)).andExpect(status().isNotFound());
		
	}
	
	@Test
	public void shouldGetRate() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		when(rateService.find(1L)).thenReturn(entityOptional);
		when(mapper.execute(entity)).thenReturn(new ApiResponse<>(ApiResponseStatus.SUCCESS));
		mockMvc.perform(get("get/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAdd() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		when(mapper.execute(new RateRequest())).thenReturn(entity);
		when(rateService.add(entity)).thenReturn(entityOptional.get());
		mockMvc.perform(get("/surcharge/get/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldUpdate() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		when(rateService.find(1L)).thenReturn(entityOptional);
		when(rateService.add(entity)).thenReturn(entityOptional.get());
		mockMvc.perform(get("/surcharge/update/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldDelete() throws Exception {
		RateEntity entity = new RateEntity();
		Optional<RateEntity> entityOptional = Optional.of(entity);
		when(rateService.find(1L)).thenReturn(entityOptional);
		when(mapper.execute(entity)).thenReturn(new ApiResponse<>(ApiResponseStatus.SUCCESS));
		mockMvc.perform(get("/surchare/get/{id}", 1L)).andExpect(status().isOk());
	}
}