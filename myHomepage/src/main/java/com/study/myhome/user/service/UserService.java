package com.study.myhome.user.service;

import java.util.Map;
	
public interface UserService {

	public Map<String, Object> findUsers(UserVO userVO) throws Exception;

	public void insertUsers(UserVO userVO, UserAuthorityVO userAuthorityVO)	throws Exception;
	
	public UserVO findUser(UserVO userVO) throws Exception;

}
