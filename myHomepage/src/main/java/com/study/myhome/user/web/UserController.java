package com.study.myhome.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.myhome.common.service.PaginationInfoMapping;
import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class UserController {

	@Autowired
	private PaginationInfoMapping mapper;

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 회원 가입 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/join.do")
	public String join() {
		return "user/join.myhome";
	}

	/**
	 * 회원 가입
	 * 
	 * @author 정명성
	 * @create date : 2016. 9. 27.
	 */
	@RequestMapping(value = "/user/join/action.do", method = RequestMethod.POST)
	public String join(@Valid @ModelAttribute("userVO") UserVO userVO,
			BindingResult biResult, UserAuthorityVO userAuthorityVO)
			throws Exception {
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

	/**
	 * 사용자 로그인 페이지
	 * 
	 * @author 정명성
	 * @create date : 2016. 10. 4.
	 * @return
	 */
	@RequestMapping(value = "/user/login.do")
	public String login() {

		return "user/login.myhome";
	}

	/**
	 * 로그인 처리
	 * 
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value = "/user/login/action.do")
	public String loginAction(HttpServletRequest reqeust,
			@Valid @ModelAttribute UserVO userVO, BindingResult biresult)
			throws Exception {
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

		reqeust.getSession().setAttribute("LoginVO", loginVO);

		return "redirect:/index.do";
	}

	/**
	 * 사용자 리스트 조회
	 * 
	 * @author 정명성 create date : 2016. 10. 5.
	 * @param request
	 * @param paginationInfo
	 * @param userVO
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/list.do")
	public String userList(HttpServletRequest request,
			PaginationInfo paginationInfo, UserVO userVO, ModelMap modelMap)
			throws Exception {

		/**
		 * paginationInfo 에는 페이징에 필요한 값들이 셋팅되어있다. 페이징 계산 식에 대해서는 해당 클래스를 열어보면
		 * 자세히 알 수 있다.
		 */

		BeanUtils.copyProperties(paginationInfo, userVO);

		// list와 전체 페이징 갯수를 가져와야 한다.
		Map resultMap = userService.findUsers(userVO);
		// total 갯수
		int totalCnt = (int) resultMap.get("totalCnt");

		// 페이징 된 리스트 갯수
		modelMap.addAttribute("list", resultMap.get("list"));

		paginationInfo.setTotalRecordCount(totalCnt);
		// 페이징 정보
		modelMap.addAttribute("paginationInfo", paginationInfo);
		// 파라미터 정보
		modelMap.addAttribute("vo", userVO);

		return "user/list.myhome";
	}

}
