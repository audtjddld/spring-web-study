package com.study.myhome.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "parameter is valid")
	@ExceptionHandler(BadRequestException.class)
	public void badRequestException(Exception e) {
		e.printStackTrace();
	}
}
