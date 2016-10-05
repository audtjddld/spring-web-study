package com.study.myhome.user;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.study.myhome.user.service.UserVO;
import com.study.myhome.user.service.impl.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// 메소드 이름으로 오름차순으로 실행 됨.
public class UserDAOTest {

	private static Logger LOG = LoggerFactory.getLogger(UserDAOTest.class);

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 사용자 정보 조회
	 * @author 정명성
	 * create date : 2016. 10. 4.
	 * @throws Exception
	 */
	@Test
	public void test1GetUser() throws Exception {
		List<UserVO> list = userDAO.getUsers(new UserVO());
		list.forEach(user -> {
			LOG.info("user : {} . {} . {}", user.getUsername(),
					user.getPassword(), user.getJoinDate());
		});
	}
	
	/**
	 * 사용자 정보 입력
	 * @author 정명성
	 * create date : 2016. 10. 4.
	 * @throws Exception
	 */
	@Test 
	public void test2InsertUser() throws Exception {
		UserVO userVO = new UserVO();
		userVO.setUsername("test");
		userVO.setPassword("1234");
		userDAO.insertUser(userVO);
		
		test1GetUser();
	}
}
