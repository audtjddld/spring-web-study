package com.study.myhome.user.service;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.study.myhome.enums.AdminYN;
import com.study.myhome.menu.service.MenuVO;

@Alias("UserAuthorityVO")
public class UserAuthorityVO {
	
	@NotNull
	private String username;
	
	private AdminYN admin_yn = AdminYN.N;
	
	// 권한별 메뉴
	private MenuVO menus;
	
	public MenuVO getMenus() {
		return menus;
	}

	public void setMenus(MenuVO menus) {
		this.menus = menus;
	}

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
