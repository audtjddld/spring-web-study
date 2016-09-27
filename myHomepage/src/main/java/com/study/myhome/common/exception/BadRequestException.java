package com.study.myhome.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;


/**
 * 파라미터 에러
 * @author 정명성
 * create date : 2016. 9. 27.
 * com.study.myhome.common.exception.BadRequestException.java
 */
public class BadRequestException extends HttpStatusCodeException {
	
	public BadRequestException(String statusText) {
		super(HttpStatus.BAD_REQUEST, statusText);
	}
	
}
