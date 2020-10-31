package com.demo.retail.request;

import com.demo.retail.constants.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.demo.retail.request.validate.ValidDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateRequest {
	
	@JsonProperty(value =Constants.RATE_DESCRIPTION)
	private String description;
	@ValidDate
	@JsonProperty(value =Constants.RATE_EFFECTIVE_DATE)
	private String effectiveDate;
	@JsonProperty(value =Constants.RATE_EXPIRATION_DATE)
	@ValidDate
	private String expireationDate;
	@JsonProperty(value =Constants.RATE_AMOUNT)
	@NotNull
	@Positive
	private BigDecimal amount;
	@NotNull
	@Positive
	private BigDecimal surcharge;

}
