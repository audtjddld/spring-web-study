package com.study.myhome.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.myhome.common.service.impl.CommonDAO;
import com.study.myhome.user.service.UserVO;

@Repository
public class UserDAO extends CommonDAO {

	public List<UserVO> getUsers() throws Exception {
		return (List<UserVO>) sqlTempate.queryForList("UserDAO.selectUsers");
	}
}
