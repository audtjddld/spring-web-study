package com.study.myhome.main.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * 메인 페이지
	 * @author 정명성
	 * create date : 2016. 9. 26.
	 * @return
	 */
	@RequestMapping(value = "/index.do")
	public String index() {
		LOG.info("goView");
		return "main/index.myhome";
	}
	
	
	@RequestMapping(value = "/test.do")
	public String index2() {
		LOG.info("goView");
		return "test/index.myhome";
	}
}
