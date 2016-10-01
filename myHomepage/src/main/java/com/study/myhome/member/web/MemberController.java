package com.study.myhome.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.myhome.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member/list.do")
	public String getMemebers(ModelMap modelMap) {

		modelMap.addAttribute("list", memberService.getMembers());

		return "member/list.myhome";
	}
}
