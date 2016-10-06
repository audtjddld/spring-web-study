package com.study.myhome.user.service;

import org.apache.ibatis.type.Alias;

@Alias("UserAuthorityVO")
public class UserAuthorityVO {
	private String username;
	private String admin_yn;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}

	public UserAuthorityVO(String username, AdminYN adminYN) {
		super();
		this.username = username;
		this.admin_yn = adminYN.name();
	}
	
	public UserAuthorityVO() {
		
	}
}
