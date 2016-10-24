package com.study.myhome.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.myhome.common.service.impl.CommonDAO;
import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserVO;

@Repository
public class UserAuthorityDAO extends CommonDAO {
	/**
	 * 권한 조회
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param userVO
	 * @return
	 */
	public UserAuthorityVO getUserAuthority(UserVO userVO) {
		return sessionTemplate.selectOne("UserAuthorityDAO.selectUserAuthorities", userVO);
	}
	
	/**
	 * 사용자 권한 입력
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param userAuthorityVO
	 */
	public void insertUserAuthority(UserAuthorityVO userAuthorityVO) {
		sessionTemplate.insert("UserAuthorityDAO.insertUserAuthority", userAuthorityVO);
	}
}
