package com.study.myhome.user.service;

import org.apache.ibatis.type.Alias;

@Alias("UserAuthorityVO")
public class UserAuthorityVO {
	
	private String username;
	
	private AdminYN admin_yn = AdminYN.N;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserAuthorityVO(String username, AdminYN admin_yn) {
		super();
		this.username = username;
		this.admin_yn = admin_yn;
	}

	public AdminYN getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(AdminYN admin_yn) {
		this.admin_yn = admin_yn;
	}

	public UserAuthorityVO() {

	}
}
