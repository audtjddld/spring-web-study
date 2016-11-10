package com.study.myhome.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.myhome.common.service.PaginationInfoMapping;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PaginationInfoMapping mapper;

	@Autowired
	private UserService userService;

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
	public String userList(HttpServletRequest request, PaginationInfo paginationInfo, UserVO userVO, ModelMap modelMap)
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

		return "user/list.myhome";
	}

	@RequestMapping(value = "/user/{username}.do")
	public String userDetail(@PathVariable("username") String username, ModelMap modelMap) throws Exception {

		UserVO user = userService.findUser(new UserVO(username));
		modelMap.addAttribute("user", user);

		return "user/view.myhome";
	}
}
