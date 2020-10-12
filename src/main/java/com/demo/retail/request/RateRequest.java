package com.demo.retail.request;

import com.demo.retail.constants.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateRequest {
	@JsonProperty(value =Constants.RATE_ID)
	private Long id;
	@JsonProperty(value =Constants.RATE_DESCRIPTION)
	private String description;
	@JsonProperty(value =Constants.RATE_EFFECTIVE_DATE)
	private String effectiveDate;
	@JsonProperty(value =Constants.RATE_EXPIRATION_DATE)
	private String expireationDate;
	@JsonProperty(value =Constants.RATE_AMOUNT)
	private int amount;

}
