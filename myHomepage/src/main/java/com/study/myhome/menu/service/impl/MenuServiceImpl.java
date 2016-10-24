package com.study.myhome.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myhome.common.exception.BadRequestException;
import com.study.myhome.menu.service.MenuDetailVO;
import com.study.myhome.menu.service.MenuService;
import com.study.myhome.menu.service.MenuVO;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDAO;

	@Override
	public MenuVO findMenus(MenuVO menuVO) throws Exception {
		// TODO Auto-generated method stub
		MenuVO menu;
		try {
			menu = menuDAO.findMenus(menuVO);
			if (menu == null) {
				throw new BadRequestException("메뉴가 존재하지 않습니다. menu_idx : "
						+ menuVO.getMenu_idx());
			}

			List<MenuDetailVO> menuDetails = menuDAO.findMenuDetails(menu.getMenu_idx());

			if (menuDetails != null) {
				menu.setMenuDetails(menuDetails);
			}

		} catch (Exception e) {
			//e.printStackTrace();
			throw (BadRequestException) e;
		}

		return menu;
	}
}
