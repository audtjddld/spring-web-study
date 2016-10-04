package com.study.myhome.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.myhome.common.service.PaginationInfoMapping;
import com.study.myhome.user.service.UserVO;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class UserController {

	@Autowired
	private PaginationInfoMapping mapper;
	
	private static Logger LOG = LoggerFactory.getLogger(UserController.class);

	/**
	 * 회원 가입
	 * @author 정명성 
	 * @create date : 2016. 9. 27.
	 */
	@RequestMapping(value = "/user/join.do", method = RequestMethod.POST)
	public String join(@Valid @ModelAttribute("userVO") UserVO userVO,
			BindingResult biResult) throws Exception {
		if (biResult.hasErrors()) {
			LOG.info("Validation Error!!");
			System.out.println(biResult.getFieldError());
			// throw new
			// BadRequestException(biResult.getAllErrors().toString());
			return "redirect:/index.do";
		}
		LOG.info("goView");
		return "redirect:/index.do";
	}
	
	/**
	 * 사용자 로그인
	 * @author 정명성
	 * @create date : 2016. 10. 4.
	 * @return
	 */
	@RequestMapping(value = "/user/login.do")
	public String login() {

		return "user/login.myhome";
	}
	
	
	@RequestMapping(value = "/user/list.do")
	public String userList(HttpServletRequest request, PaginationInfo paginationInfo, UserVO userVO) throws Exception {
		
		mapper.setPaginationInfo(paginationInfo, userVO);
		
		return null;
	}
}
