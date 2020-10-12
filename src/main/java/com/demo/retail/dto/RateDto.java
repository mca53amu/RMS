package com.demo.retail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateDto {
	private Long id;
	private String description;
	private String effectiveDate;
	private String expireationDate;
	private int amount;

}
