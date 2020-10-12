package com.demo.retail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.retail.hibernate.entity.RateEntity;
@Repository
public interface RateRepository extends CrudRepository<RateEntity,Long> {

}
