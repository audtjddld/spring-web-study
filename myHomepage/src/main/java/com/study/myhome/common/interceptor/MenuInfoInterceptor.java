package com.study.myhome.common.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

public class MenuInfoInterceptor extends WebContentInterceptor {

	private static Logger LOG = LoggerFactory
			.getLogger(MenuInfoInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOG.info("menuInterceptor postHandle");
	}

}
