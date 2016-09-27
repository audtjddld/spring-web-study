package com.study.myhome.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder
public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders
					.webAppContextSetup(this.wac)
					.alwaysDo(MockMvcResultHandlers.print())
					.build();
	}

	/**
	 * validation test. 
	 * controller 에서 @Valid 애노테이션을 이용한 Error 검증이 정확히 되는지 검증
	 * @author 정명성
	 * create date : 2016. 9. 27.
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		mockMvc.perform(
						post("/user/join.do")
							.param("username", "1")
							//.param("password", "123412341234")	// validation test
						)
				.andExpect(
							model().attributeHasFieldErrors("userVO", "password", "username")
						  );
	}
}
