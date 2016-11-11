package com.study.myhome.common.service.impl;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import egovframework.com.cmm.LoginVO;

//@Component
public class DuplicationLoginComponent implements HttpSessionBindingListener {
	private final static Logger LOG = LoggerFactory.getLogger(DuplicationLoginComponent.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 해당 아이디가 사용중인지
	 * 
	 * @param username
	 * @return
	 */
	public boolean isUsing(String username, HttpSession session) {
		boolean isUsing = false;
		
		String redis_username = redisTemplate.opsForValue().get(session.getId());
		if(redis_username.equals(username)) {
			return true;
		}
		
		System.out.println("is Using " + isUsing);
		return isUsing;
	}

	/**
	 * 세션 생성 , user 저장
	 * 
	 * @param session
	 * @param userID
	 */
	public void setSession(HttpSession session, String userID) {
		LOG.info("sessionId : {}, userID : {}", session.getId(), userID);
		redisTemplate.expire( session.getId(), 1, TimeUnit.HOURS );
		redisTemplate.opsForValue().set(session.getId(), userID);
		
	}

	/**
	 * 세션 생성될때
	 */
	public void valueBound(HttpSessionBindingEvent event) {
		LOG.info("valueBound : {} ", event.toString());
		// TODO Auto-generated method stub
		if(event.getSession().getAttribute("LoginVO") != null ) {
			LOG.info("created user Session");
			LoginVO loginVO = (LoginVO) event.getSession().getAttribute("LoginVO");
			redisTemplate.opsForValue().set(event.getSession().getId(), loginVO.getUsername());
		}
	}

	/**
	 * 세션 끊길 때
	 */
	public void valueUnbound(HttpSessionBindingEvent event) {
		LOG.info("delete user session");
		// TODO Auto-generated method stub
		redisTemplate.delete(event.getSession().getId());
	}
	
}
