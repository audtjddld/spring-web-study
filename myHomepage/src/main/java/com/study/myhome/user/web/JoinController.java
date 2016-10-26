package com.study.myhome.user.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

@Controller
public class JoinController {

	private static Logger LOG = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	private UserService userService;

	/**
	 * 회원 가입 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value = "/join.do")
	public String join() {
		return "user/join.myhome";
	}

	/**
	 * 회원 가입
	 * 
	 * @author 정명성
	 * @create date : 2016. 9. 27.
	 */
	@RequestMapping(value = "/join/action.do", method = RequestMethod.POST)
	public String join(@Valid UserVO userVO, BindingResult biResult, UserAuthorityVO userAuthorityVO) throws Exception {
		if (biResult.hasErrors()) {
			LOG.info("Validation Error!!");
			System.out.println(biResult.getFieldError());
			// throw new
			// BadRequestException(biResult.getAllErrors().toString());
			return "redirect:/index.do";
		}
		// 사용자 정보 조회

		userService.insertUsers(userVO, userAuthorityVO);

		LOG.info("goView");
		return "redirect:/index.do";
	}
}
