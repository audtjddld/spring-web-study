package com.study.myhome.member;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.study.myhome.member.service.MemberService;
import com.study.myhome.user.service.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder
public class MemberTest {
	private Logger LOG = LoggerFactory.getLogger(MemberTest.class);
	@Autowired
	private MemberService memberService;

	@Test
	public void getMemberList() {
		List<UserVO> list = memberService.getMembers();

		list.forEach(user -> {
			LOG.info("user : {} , {}", user.getUsername(), user.getPassword() );
		});
	}
}
