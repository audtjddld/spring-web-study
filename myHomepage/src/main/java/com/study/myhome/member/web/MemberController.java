package com.study.myhome.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.myhome.member.service.MemberService;
import com.study.myhome.user.service.UserVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member/list.do")
	public String getMemebers(HttpServletRequest request, ModelMap modelMap) {
		
		List<UserVO> list = memberService.getMembers();
		modelMap.addAttribute("list",list);
		request.setAttribute("list2", list);
		
		return "member/list.myhome";
	}
	
	// /member/{username}.do
	@RequestMapping(value="/member/{username}.do")
	public String getMember(@PathVariable("username") String username, ModelMap modelMap) {
		List<UserVO> list = memberService.getMembers();
		// user5

		list.forEach(user -> {
			if(user.getUsername().equals(username)) modelMap.addAttribute("user", user);
		});
		
		return "member/view.myhome";
	}
	
}
