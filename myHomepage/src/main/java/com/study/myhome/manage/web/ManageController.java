package com.study.myhome.manage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {
	
	/**
	 * 테스트 관리자 페이지
	 * @author 정명성
	 * @create date : 2016. 10. 26.
	 * @return
	 */
	@RequestMapping(value = "/manager/index.do")
	public String manageIndex() {
		
		return "manager/index.myhome";
	}
}
