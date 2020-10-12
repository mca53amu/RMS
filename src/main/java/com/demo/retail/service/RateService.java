package com.demo.retail.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.retail.hibernate.entity.RateEntity;

@Service
public interface RateService {

	public Optional<RateEntity> find(Long id);

	public RateEntity add(RateEntity entity);


	public void delete(RateEntity entity);

}
