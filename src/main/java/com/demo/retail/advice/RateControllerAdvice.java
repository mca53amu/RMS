package com.demo.retail.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.exception.NotFoundException;
import com.demo.retail.exception.RateException;
import com.demo.retail.response.RateError;

@RestControllerAdvice
public class RateControllerAdvice {

	@ExceptionHandler(RateException.class)
	public ResponseEntity<RateError> apiException(RateException e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new RateError(e.getMessage(), ApiResponseStatus.FAIL));
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<RateError> notFoundException(NotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new RateError(e.getMessage(), ApiResponseStatus.FAIL));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RateError> generalException(Exception e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new RateError("Internal server error. Please contact admin", ApiResponseStatus.FAIL));
	}

}
