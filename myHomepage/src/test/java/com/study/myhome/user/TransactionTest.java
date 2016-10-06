package com.study.myhome.user;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import com.study.myhome.user.service.AdminYN;
import com.study.myhome.user.service.UserAuthorityVO;
import com.study.myhome.user.service.UserService;
import com.study.myhome.user.service.UserVO;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)	// 메소드 이름으로 오름차순으로 실행 됨.
public class TransactionTest {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 트랜젝션 진행.
	 * 권한 테이블과 사용자 테이블간 foreign key가 걸려 있어서 Transaction 발생
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void test1Transaction () throws Exception {
		
		UserVO userVO = new UserVO("test","1234");
		UserAuthorityVO userAuthorityVO = new UserAuthorityVO("test1", AdminYN.N);
		
		userService.insertUsers(userVO, userAuthorityVO);
	}
	
	/**
	 * 트랜젝션 처리되었는지 확인
	 * @author 정명성
	 * create date : 2016. 10. 6.
	 * @throws Exception
	 */
	@Test
	public void test2CheckTransactionFindUserInfo() throws Exception {
		UserVO userVO = userService.findUser("test");
		Assert.isNull(userVO);
	}
}
