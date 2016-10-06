package com.study.myhome.user.service;

import java.util.List;

public interface UserAuthorityService {
	
	public List<UserAuthorityVO> findUserAuthorities(UserVO userVO) throws Exception;
	
	public void insertUserAuthority(UserAuthorityVO userAuthorityVO) throws Exception;
	
}
