package com.study.myhome.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/**
	 * 사용자 리스트 가져오기
	 * @author 정명성
	 * create date : 2016. 10. 5.
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
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param userVO
	 * @throws Exception
	 */
	public void insertUsers(UserVO userVO, UserAuthorityVO userAuthorityVO) throws Exception {
		userDAO.insertUser(userVO);
		userAuthorityService.insertUserAuthority(userAuthorityVO);
	}
	
	/**
	 * 사용자 정보 조회
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public UserVO findUser(String username) throws Exception {
		return userDAO.findUser(username);
	}
}
