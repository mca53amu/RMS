package com.demo.retail.advice;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.retail.constants.ApiResponseStatus;
import com.demo.retail.constants.Constants;
import com.demo.retail.exception.ApiException;
import com.demo.retail.exception.NotFoundException;
import com.demo.retail.response.ApiResponse;
import com.demo.retail.response.RateError;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RateControllerAdvice extends ResponseEntityExceptionHandler{
	private static final Logger LOGGER = LoggerFactory.getLogger(RateControllerAdvice.class);
	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(ApiException.class)
	public ApiResponse<RateError> apiException(ApiException e) {
		
		LOGGER.error(ApiResponseStatus.FAIL.toString(), e);
		return new ApiResponse<>(ApiResponseStatus.FAIL, new RateError(e.getMessage(),null));
	}

	@ExceptionHandler(NotFoundException.class)
	public ApiResponse<RateError> notFoundException(NotFoundException e) {
		
		LOGGER.error(ApiResponseStatus.FAIL.toString(), e);
		return new ApiResponse<>(ApiResponseStatus.FAIL, new RateError(e.getMessage(),null));
	}

	@ExceptionHandler(Exception.class)
	public ApiResponse<RateError> generalException(Exception e) {
		log.error( //
				String.format( //
						"API Validation Failed. Fail Message [%s], Description [%s], Log Reference [%s] (%s:%d)", //
						ApiResponseStatus.ERROR.toString(), //
						e.getCause(), //
						request.getAttribute(Constants.LOG_REFERENCE_ID), //
						e.getStackTrace()[0].getFileName(), //
						e.getStackTrace()[0].getLineNumber() //
				) //
		);
		return new ApiResponse<>(ApiResponseStatus.ERROR, new RateError(e.getMessage(),null));
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
           HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<RateError> errors = ex.getBindingResult().getFieldErrors().stream().map(e->{
			return new RateError(e.getField(), e.getDefaultMessage());
		}).collect(Collectors.toList());
		return ResponseEntity.status(status).body(new ApiResponse<List<RateError>>(ApiResponseStatus.ERROR, errors));
		
    } 
}
