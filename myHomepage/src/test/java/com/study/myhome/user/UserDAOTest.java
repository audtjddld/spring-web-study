package com.study.myhome.user;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@FixMethodOrder
public class UserDAOTest {

	private static Logger LOG = LoggerFactory.getLogger(UserDAOTest.class);
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Test
	public void getUser() throws Exception {
		
		List<UserVO> list = userDAO.getUsers();
		list.forEach(user -> {
			LOG.info("user : {} . {} . {}", user.getUsername(), user.getPassword(), user.getJoinDate());
		});
	}
}
