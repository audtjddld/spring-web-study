package com.study.myhome.menu.service;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.study.myhome.enums.AuthorityMenu;

@Alias("MenuVO")
public class MenuVO {

	private int menu_idx;

	private String menu_name;
	// 메뉴 상세
	private List<MenuDetailVO> menuDetails;

	public MenuVO() {

	}

	public MenuVO(AuthorityMenu authorityMenu) {
		super();
		this.menu_idx = authorityMenu.ordinal();
	}

	public int getMenu_idx() {
		return menu_idx;
	}

	public void setMenu_idx(int menu_idx) {
		this.menu_idx = menu_idx;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public List<MenuDetailVO> getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(List<MenuDetailVO> menuDetails) {
		this.menuDetails = menuDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((menuDetails == null) ? 0 : menuDetails.hashCode());
		result = prime * result + menu_idx;
		result = prime * result
				+ ((menu_name == null) ? 0 : menu_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuVO other = (MenuVO) obj;
		if (menuDetails == null) {
			if (other.menuDetails != null)
				return false;
		} else if (!menuDetails.equals(other.menuDetails))
			return false;
		if (menu_idx != other.menu_idx)
			return false;
		if (menu_name == null) {
			if (other.menu_name != null)
				return false;
		} else if (!menu_name.equals(other.menu_name))
			return false;
		return true;
	}

}
