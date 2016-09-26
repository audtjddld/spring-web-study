package com.study.myhome.main.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

	/**
	 * ajax 데이터
	 * @author 정명성
	 * create date : 2016. 9. 26.
	 * @return
	 */
	@RequestMapping(value = "/index.ajax", method = RequestMethod.GET)
	public Map<String, String> index() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "hello world");
		return map;
	}
	
}
