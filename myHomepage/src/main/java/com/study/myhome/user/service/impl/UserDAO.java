package com.study.myhome.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.myhome.common.service.impl.CommonDAO;
import com.study.myhome.user.service.UserVO;

@Repository
public class UserDAO extends CommonDAO {
	
	/**
	 * 사용자 조회
	 * @author 정명성
	 * create date : 2016. 10. 4.
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> getUsers(UserVO userVO) throws Exception {
		return sessionTemplate.selectList("UserDAO.selectUsers", userVO);
	}
	
	/**
	 * 사용자 전체 리스트 카운트
	 * @author 정명성
	 * create date : 2016. 10. 4.
	 * @return
	 * @throws Exception
	 */
	public Integer getTotalUser() throws Exception {
		return sessionTemplate.selectOne("UserDAO.selectUsersTotalCnt");
	}
	
	/**
	 * 사용자 정보 입력
	 * @author 정명성
	 * create date : 2016. 10. 4.
	 * @param userVO
	 * @throws Exception
	 */
	public void insertUser(UserVO userVO) throws Exception {
		sessionTemplate.insert("UserDAO.insertUser", userVO);
	}
}
