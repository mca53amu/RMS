package com.demo.retail;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockitoSession;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.mapper.RateEntityMapper;
import com.demo.retail.request.RateRequest;
import com.demo.retail.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class RetailControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private RateEntityMapper mapper;
	@MockBean
	private RateService rateService;

	@Test
	public void shouldGet() throws Exception {
		RateEntity entityObject = getEntityObject();
		Mockito.when(rateService.find(1L)).thenReturn(Optional.of(entityObject));
		Mockito.when(mapper.execute(entityObject)).thenCallRealMethod();
		mvc.perform(get("/surcharge/get/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	public void shouldAdd() throws Exception {

		RateRequest requestObject = getRequestObject();
		RateEntity entity = getEntityObject();
		RateEntity value = new RateEntity();
		Mockito.when(rateService.add(null)).thenReturn(entity);
		Mockito.when(mapper.execute(value)).thenCallRealMethod();
		mvc.perform(
				post("/surcharge/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(requestObject)));

	}

//	
	@Test
	public void shouldUpdate() throws Exception {
		RateEntity entityObject = getEntityObject();
		Mockito.when(rateService.find(1L)).thenReturn(Optional.of(entityObject));
		RateRequest request = getRequestObject();
		Mockito.when(mapper.copyValues(entityObject, request)).thenCallRealMethod();
		Mockito.when(rateService.add(entityObject)).thenReturn(entityObject);
		Mockito.when(mapper.execute(entityObject)).thenCallRealMethod();
		mvc.perform(post("/surcharge/update/{id}", 1L).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(request))).andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("SUCCESS")));

	}

	@Test
	public void shouldReturn404WhenFIndUserById() throws Exception {

		final long userId = 1L;
		Mockito.when(rateService.find(userId)).thenReturn((Optional.empty()));
		mvc.perform(get("/surcharge/get/{id}", -1L)).andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("FAIL")));
		;

	}

	@Test
	public void shouldShouldThrowException() throws Exception {

		final long userId = 1L;
		Mockito.when(rateService.find(userId)).thenReturn((Optional.empty()));
		try {
			mvc.perform(get("/surcharge/get/{id}", -1L));
		} catch (Exception e) {
			assertEquals("RateId not found in RMS", e.getMessage());
		}

	}

	@Test
	public void shouldDelete() throws Exception {
		RateEntity entityObject = getEntityObject();
		Mockito.when(rateService.find(1L)).thenReturn(Optional.of(entityObject));
		Mockito.doNothing().when(rateService).delete(entityObject);
		mvc.perform(MockMvcRequestBuilders.delete("/surcharge/delete/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.status", is("SUCCESS")));

	}

	private RateRequest getRequestObject() {
		RateRequest requestObject = new RateRequest();
		requestObject.setAmount(new BigDecimal(24));
		requestObject.setDescription("Test Description");
		requestObject.setEffectiveDate("2018-09-20");
		requestObject.setExpireationDate("2018-09-20");
		return requestObject;
	}

	private RateEntity getEntityObject() {
		RateEntity entity = new RateEntity();
		entity.setId(1L);
		entity.setAmount(25);
		entity.setDescription("Description");
		entity.setEffectiveDate(Date.valueOf("2018-09-20"));
		entity.setExpireationDate(Date.valueOf("2018-09-20"));
		return entity;
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
