package com.demo.retail.controller;

import java.util.Optional;
import static com.demo.retail.constants.Constants.NOT_FOUND_ERROR_MSG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.retail.advice.RateControllerAdvice;
import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.constants.Constants;
import com.demo.retail.exception.NotFoundException;
import com.demo.retail.hibernate.entity.RateEntity;
import com.demo.retail.mapper.RateEntityMapper;
import com.demo.retail.request.RateRequest;
import com.demo.retail.response.ApiResponse;
import com.demo.retail.response.RateResponse;
import com.demo.retail.service.RateService;


@RestController
@RequestMapping("/surcharge")
public class RateController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RateController.class);
	@Autowired 
	private RateService rateService;
	
	@Autowired
	private RateEntityMapper mapper;
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<RateResponse> getRate(@PathVariable Long id) throws Exception{
		
		Optional<RateEntity> entityOptional = rateService.find(id);
		RateEntity entity = entityOptional.orElseThrow(()-> new NotFoundException(Constants.NOT_FOUND_ERROR_MSG));
		RateResponse execute = mapper.execute(entity);
		return ResponseEntity.ok(execute);
	}

	@PostMapping("/add")
	public ResponseEntity<RateResponse> add(@RequestBody RateRequest request)throws Exception {
		
		RateEntity execute = mapper.execute(request);
		RateEntity entity = rateService.add(execute);
		RateResponse response=mapper.execute(entity);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<RateResponse> update(@PathVariable Long id,@RequestBody RateRequest requst)throws Exception {
		Optional<RateEntity> entityOptional = rateService.find(id);
		RateEntity entity = entityOptional.orElseThrow(()-> new NotFoundException(NOT_FOUND_ERROR_MSG));
		entity=mapper.copyValues(entity,requst);
		RateEntity add = rateService.add(entity);
		RateResponse response = mapper.execute(add);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long id) throws Exception{
		Optional<RateEntity> entityOptional = rateService.find(id);
		RateEntity entity = entityOptional.orElseThrow(()-> new NotFoundException(NOT_FOUND_ERROR_MSG));
		rateService.delete(entity);
		return ResponseEntity.ok(new ApiResponse(ApiResponseStatus.SUCCESS));
	}

}