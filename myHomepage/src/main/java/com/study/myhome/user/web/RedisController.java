package com.study.myhome.user.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedisController {

	@Autowired
	private RedisTemplate<String, String> template;

	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;

	@RequestMapping(value = "/redis/list.do")
	public void getList() {
		System.out.println(listOps.getOperations().opsForList());
	}

	@RequestMapping(value = "/redis/value.do")
	public void getValue(@RequestParam(required = true) String key) {
		System.out.println("key : " + key);
		System.out.println(valueOps.get(key));
	}
	
	@RequestMapping(value="/redis/setValue.do")
	public void setValue() {
		valueOps.set("name", "jms");
		valueOps.set("name2", "jms");
		valueOps.set("name", "jms2");
	}
}
