package com.demo.retail.response;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.constants.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value=Include.NON_NULL)
public class RateResponse extends ApiResponse {

	@JsonProperty(value = Constants.RATE_ID)
	private Long id;
	@JsonProperty(value = Constants.RATE_DESCRIPTION)
	private String description;
	@JsonProperty(value = Constants.RATE_EFFECTIVE_DATE)
	private String effectiveDate;
	@JsonProperty(value = Constants.RATE_EXPIRATION_DATE)
	private String expireationDate;
	@JsonProperty(value = Constants.RATE_AMOUNT)
	private Float amount;
	@JsonProperty(value = Constants.SURCHARGE)
	private Float surchage;

	public RateResponse() {
		super(ApiResponseStatus.SUCCESS);
	}
}