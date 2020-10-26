package com.demo.retail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.repository.RateRepository;
import com.demo.retail.service.RateServiceImpl;

@SpringBootTest
public class RateServiceTest {

	@Mock
	private RateRepository repository;
	
	@InjectMocks
	private RateServiceImpl rateService;

	@Test
	public void testFind() {
		RateEntity entity = new RateEntity();
		entity.setId(1L);
		entity.setAmount(25);
		entity.setDescription("2018-09-20");
		Optional<RateEntity> rateEntityOptional=Optional.of(entity);
		when(repository.findById(new Long(1))).thenReturn(rateEntityOptional);
		Optional<RateEntity> expected = rateService.find(1L);
		assertThat(expected).isNotNull();
		
	}
	
	@Test
	public void testAdd() {
		RateEntity entity = new RateEntity();
		entity.setId(1L);
		entity.setAmount(25);
		entity.setDescription("2018-09-20");
		when(repository.save(entity)).thenReturn(entity);
		RateEntity expected = rateService.add(entity);
		assertThat(expected).isNotNull();
		
	}
	
	@Test
	public void testDelete() {
		RateEntity entity = new RateEntity();
		entity.setId(1L);
		entity.setAmount(25);
		entity.setDescription("2018-09-20");
		Optional<RateEntity> rateEntityOptional=Optional.of(entity);
		when(repository.delete(entity)).thenDoNothing();
		rateService.delete(entity);
		verify(entity);
	}
}