package com.study.myhome.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	/**
	 * 사용자 리스트 가져오기
	 * @author 정명성
	 * create date : 2016. 10. 5.
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getUsers(UserVO userVO) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", userDAO.getUsers(userVO));
		map.put("totalCnt", userDAO.getTotalUser());
		return map;
	}
}
