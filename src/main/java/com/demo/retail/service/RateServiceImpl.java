package com.demo.retail.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.repository.RateRepository;

@Service
@Transactional
public class RateServiceImpl  implements RateService{

	@Autowired
	private RateRepository repository;
	
	@Override
	public Optional<RateEntity> find(Long id) {
		Optional<RateEntity> findById = repository.findById(id);
		return findById;
	}

	@Override
	public RateEntity add(RateEntity entity) {
		RateEntity save = repository.save(entity);
		return save;
	}

	@Override
	public void delete(RateEntity entity) {
		repository.delete(entity);
	}

}
