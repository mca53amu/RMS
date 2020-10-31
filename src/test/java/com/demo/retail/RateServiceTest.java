package com.demo.retail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.repository.RateRepository;
import com.demo.retail.service.RateService;
import com.demo.retail.service.RateServiceImpl;

@RunWith(SpringRunner.class)
public class RateServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public RateService employeeService() {
			return new RateServiceImpl();
		}
	}

	@MockBean
	private RateRepository repository;

	@Autowired
	private RateServiceImpl rateService;

	@Test
	public void testFind() {
		RateEntity entity = getEntityObject();
		Optional<RateEntity> rateEntityOptional = Optional.of(entity);
		Mockito.when(repository.findById(new Long(1))).thenReturn(rateEntityOptional);
		Optional<RateEntity> expected = rateService.find(1L);
		assertThat(expected).isNotEmpty();

	}
	

	@Test
	public void testAdd() {
		RateEntity entity = getEntityObject();
		Mockito.when(repository.save(entity)).thenReturn(entity);
		RateEntity expected = rateService.add(entity);
		assertThat(expected).isNotNull();

	}
	
	@Test
	public void testDelete() {
		RateEntity entity = getEntityObject();
		Mockito.doNothing().when(repository).delete(entity);
		rateService.delete(entity);
		verify(repository, times(1)).delete(entity);
	}

	private RateEntity getEntityObject() {
		RateEntity entity = new RateEntity();
		entity.setId(1L);
		entity.setAmount(25.40F);
		entity.setDescription("2018-09-20");
		return entity;
	}

}