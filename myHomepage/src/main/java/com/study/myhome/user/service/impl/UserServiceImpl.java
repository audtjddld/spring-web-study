package com.study.myhome.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myhome.common.exception.BadRequestException;
import com.study.myhome.enums.AdminYN;
import com.study.myhome.enums.AuthorityMenu;
import com.study.myhome.menu.service.MenuService;
import com.study.myhome.menu.service.MenuVO;
import com.study.myhome.user.service.UserAuthorityService;
import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserAuthorityService userAuthorityService;

	@Autowired
	private MenuService menuService;

	/**
	 * 사용자 리스트 가져오기
	 * 
	 * @author 정명성 create date : 2016. 10. 5.
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findUsers(UserVO userVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", userDAO.findUsers(userVO));
		map.put("totalCnt", userDAO.getTotalUser());
		return map;
	}

	/**
	 * 사용자 정보 입력
	 * 
	 * @author 정명성 create date : 2016. 10. 6.
	 * @param userVO
	 * @throws Exception
	 */
	public void insertUsers(UserVO userVO, UserAuthorityVO userAuthorityVO)
			throws Exception {
		try {
			userDAO.insertUser(userVO);
			userAuthorityService.insertUserAuthority(userAuthorityVO);
		} catch (Exception e) {
			throw (BadRequestException) e;
		}
	}

	/**
	 * 사용자 정보 조회
	 * 
	 * @author 정명성 create date : 2016. 10. 6.
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public UserVO findUser(UserVO userVO) throws Exception {
		try {
			
			UserVO user = userDAO.findUser(userVO);
			if (user == null) {
				throw new BadRequestException("사용자가 존재하지 않습니다. username : "	+ userVO.getUsername());
			}
			// 권한 가져오기
			setUserAuthority(user);
			System.out.println(ToStringBuilder.reflectionToString(userVO.getUserAuthority()));
			// 메뉴 가져오기
			setMenu(user.getUserAuthority());

			return user;
		} catch (BadRequestException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 사용자 권한
	 * @author 정명성
	 * @create date : 2016. 10. 31.
	 * @param user
	 * @throws Exception
	 */
	private void setUserAuthority(UserVO user) throws Exception {
		UserAuthorityVO userAuthority = userAuthorityService.findUserAuthority(user);
		if(userAuthority == null) {
			throw new BadRequestException("권한 정보가 없습니다. username : " + user.getUsername());
		}
		user.setUserAuthority(userAuthority);
	}
	
	/**
	 * 메뉴 저장
	 * @author 정명성
	 * create date : 2016. 10. 24.
	 * @param userAuthority
	 * @throws Exception
	 */
	private void setMenu(UserAuthorityVO userAuthority) throws Exception {
		MenuVO menu;
		if (userAuthority.getAdmin_yn().equals(AdminYN.Y)) {
			menu = menuService.findMenus(new MenuVO(AuthorityMenu.ADMIN));
		} else {
			menu = menuService.findMenus(new MenuVO(AuthorityMenu.MEMBER));
		}
		if (menu != null) {
			userAuthority.setMenus(menu);
		}
	}

}
