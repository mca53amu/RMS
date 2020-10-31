package com.demo.retail.hibernate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "RateDescription")
	private String description;
	@Column(name = "RateEffectiveDate", nullable = false)
	private Date effectiveDate;
	@Column(name = "RateExpirationDate", nullable = false)
	private Date expireationDate;
	@Column(name = "amount", nullable = false)
	private Float amount;
	@Column(name = "surcharge", nullable = false)
	private Float surcharge;

}
