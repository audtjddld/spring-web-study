package com.study.myhome.menu;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import com.study.myhome.common.exception.BadRequestException;
import com.study.myhome.menu.service.MenuService;
import com.study.myhome.menu.service.MenuVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// 메소드 이름으로 오름차순으로 실행 됨.
public class MenuTest {

	@Autowired
	private MenuService menuService;

	@Test
	public void test1GetMenu() throws Exception {
		MenuVO menuVO = new MenuVO();
		menuVO.setMenu_idx(1);
		menuVO = menuService.findMenus(menuVO);

		Assert.notNull(menuVO);
		Assert.notNull(menuVO.getMenuDetails());
	}

	@Test(expected = BadRequestException.class)
	public void test2GetMenuError() throws Exception {
		MenuVO menuVO = new MenuVO();
		menuVO.setMenu_idx(4);
		menuVO = menuService.findMenus(menuVO);
	}
}
