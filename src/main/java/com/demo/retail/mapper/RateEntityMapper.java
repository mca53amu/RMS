package com.demo.retail.mapper;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.request.RateRequest;
import com.demo.retail.response.ApiResponse;
import com.demo.retail.response.RateResponse;

@Component
public class RateEntityMapper {

	public RateEntity execute(RateRequest rateRequest) {
		RateEntity entity = new RateEntity();
		RateEntity copyValues = copyValues(entity, rateRequest);
		return copyValues;
	}

	public ApiResponse<RateResponse> execute(RateEntity entity) {
		RateResponse response = new RateResponse();
		response.setAmount(entity.getAmount());
		response.setDescription(entity.getDescription());
		response.setEffectiveDate(entity.getEffectiveDate().toString());
		response.setExpireationDate(entity.getExpireationDate().toString());
		response.setId(entity.getId());
		return new ApiResponse<RateResponse>(ApiResponseStatus.SUCCESS, response);
	}

	public RateEntity copyValues(RateEntity entity, RateRequest request) {
		entity.setId(request.getId());
		entity.setAmount(request.getAmount());
		entity.setDescription(request.getDescription());
		entity.setEffectiveDate(Date.valueOf(request.getEffectiveDate()));
		entity.setExpireationDate(Date.valueOf(request.getExpireationDate()));
		return entity;
	}

}
