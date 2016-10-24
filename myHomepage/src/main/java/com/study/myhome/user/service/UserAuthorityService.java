package com.study.myhome.user.service;

import java.util.List;

public interface UserAuthorityService {
	
	public UserAuthorityVO findUserAuthority(UserVO userVO) throws Exception;
	
	public void insertUserAuthority(UserAuthorityVO userAuthorityVO) throws Exception;
	
}
