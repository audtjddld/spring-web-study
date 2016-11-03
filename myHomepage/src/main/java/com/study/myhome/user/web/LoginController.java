package com.study.myhome.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.myhome.common.service.impl.DuplicationLoginComponent;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

import egovframework.com.cmm.LoginVO;

@Controller
public class LoginController extends DuplicationLoginComponent {

	private static Logger LOG = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	private UserService userService;

	/**
	 * 사용자 로그인 페이지
	 * 
	 * @author 정명성
	 * @create date : 2016. 10. 4.
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	public String login() {

		return "user/login.myhome";
	}

	/**
	 * 로그인 처리
	 * 
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value = "/login/action.do")
	public String loginAction(HttpServletRequest reqeust, @Valid UserVO userVO, BindingResult biresult) throws Exception {
		// 파라미터 검증
		if (biresult.hasErrors()) {
			return "redirect:/user/login.do?result=parameter";
		}
		// 사용자 정보 조회
		UserVO user = userService.findUser(userVO);

		if (user == null) {
			return "redirect:/user/login.do?result=notFound";
		}

		LoginVO loginVO = new LoginVO();
		BeanUtils.copyProperties(loginVO, user);

		
		HttpSession session = reqeust.getSession();
		session.setAttribute("LoginVO", loginVO);
		setSession(session, loginVO.getUsername());
		
		return "redirect:/index.do";
	}
	
	/**
	 * 로그아웃
	 * @author 정명성
	 * @create date : 2016. 11. 1.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("LoginVO", null);
		
		return "redirect:/index.do";
	}
}
