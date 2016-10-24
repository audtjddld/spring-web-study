package com.study.myhome.user.service;

public interface UserAuthorityService {

	public UserAuthorityVO findUserAuthority(UserVO userVO) throws Exception;

	public void insertUserAuthority(UserAuthorityVO userAuthorityVO)
			throws Exception;

}
