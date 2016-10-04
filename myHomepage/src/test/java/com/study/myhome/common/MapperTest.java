package com.study.myhome.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.study.myhome.common.service.PaginationInfoMapping;
import com.study.myhome.user.service.UserVO;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:/egovframework/spring/com/context-*.xml",
		"file:src/main/webapp/WEB-INF/config/*.xml" })
@WebAppConfiguration
@FixMethodOrder
public class MapperTest {
	
	@Autowired	
	private PaginationInfoMapping mapper;
	
	@Test
	public void dozerTest() throws Exception {
		UserVO userVO = new UserVO();
		userVO.setP(2);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		mapper.setPaginationInfo(paginationInfo, userVO);
		
		System.out.println(ToStringBuilder.reflectionToString(paginationInfo));
	}
}
