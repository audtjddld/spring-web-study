package com.study.myhome.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * 메인 페이지
	 * @author 정명성
	 * create date : 2016. 9. 26.
	 * @return
	 */
	@RequestMapping(value = "/index.do")
	public String index() {
		return "main/index.main";
	}
	
	
	@RequestMapping(value = "/test.do")
	public String index2() {
		return "test/index.main";
	}
}
