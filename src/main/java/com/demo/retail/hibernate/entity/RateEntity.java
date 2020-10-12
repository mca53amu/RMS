package com.demo.retail.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "RATE")
@Entity
public class RateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RateId", nullable = false)
	private Long id;
	@Column(name = "RateDescription", nullable = true)
	private String description;
	@Column(name = "RateEffectiveDate", nullable = false)
	private String effectiveDate;
	@Column(name = "RateExpirationDate", nullable = false)
	private String expireationDate;
	@Column(name = "amount", nullable = false)
	private Integer amount;

}
