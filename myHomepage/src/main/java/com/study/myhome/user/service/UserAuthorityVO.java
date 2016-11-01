package com.study.myhome.user.service;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.study.myhome.enums.AdminYN;
import com.study.myhome.enums.Authority;
import com.study.myhome.menu.service.MenuVO;

@Alias("UserAuthorityVO")
public class UserAuthorityVO {
	
	@NotNull
	private String username;
	
	private Authority authority = Authority.MEMBER;
	
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
	
	public UserAuthorityVO(String username, Authority authority, MenuVO menus) {
		super();
		this.username = username;
		this.authority = authority;
		this.menus = menus;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public UserAuthorityVO() {

	}
}
