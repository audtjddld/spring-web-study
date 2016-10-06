package com.study.myhome.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myhome.user.service.UserAuthorityService;
import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserVO;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {
	
	@Autowired
	private UserAuthorityDAO userAuthorityDAO;
	
	/**
	 * 사용자 권한 조회
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	public List<UserAuthorityVO> findUserAuthorities(UserVO userVO) throws Exception {
		return userAuthorityDAO.getUserAuthorities(userVO);
	}
	
	/**
	 * 사용자 권한 입력
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param userAuthorityVO
	 * @throws Exception
	 */
	public void insertUserAuthority(UserAuthorityVO userAuthorityVO) throws Exception {
		userAuthorityDAO.insertUserAuthority(userAuthorityVO);
	}
}
