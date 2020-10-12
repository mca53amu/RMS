package com.demo.retail.mapper;

import org.springframework.stereotype.Component;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.request.RateRequest;
import com.demo.retail.response.RateResponse;

@Component
public class RateEntityMapper {
	
	public RateEntity execute(RateRequest rateRequest) {
		RateEntity entity=new RateEntity();
		RateEntity copyValues = copyValues(entity, rateRequest);
		return copyValues;
	}

	public RateResponse execute(RateEntity entity) {
		RateResponse response=new RateResponse(ApiResponseStatus.SUCCESS);
		response.setAmount(entity.getAmount());
		response.setDescription(entity.getDescription());
		response.setEffectiveDate(entity.getEffectiveDate());
		response.setExpireationDate(entity.getExpireationDate());
		response.setId(entity.getId());
		return response;
	}

	public RateEntity copyValues(RateEntity entity, RateRequest request) {
		entity.setId(request.getId());
		entity.setAmount(request.getAmount());
		entity.setDescription(request.getDescription());
		entity.setEffectiveDate(request.getEffectiveDate());
		entity.setExpireationDate(request.getExpireationDate());
		return entity;
	}
	
}
