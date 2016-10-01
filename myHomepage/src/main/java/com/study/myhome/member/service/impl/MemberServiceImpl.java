package com.study.myhome.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.myhome.common.exception.BadRequestException;
import com.study.myhome.member.service.MemberService;
import com.study.myhome.user.service.UserVO;

@Service
public class MemberServiceImpl implements MemberService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.study.myhome.member.service.impl.MemberService#getMembers()
	 */
	@Transactional
	public List<UserVO> getMembers() {
		List<UserVO> list = new ArrayList();
		try {

			for (int i = 0; i < 20; i++) {
				UserVO user = new UserVO();
				user.setUsername("user" + i);
				user.setPassword("1234" + i);

				list.add(user);
			}
			throw new Exception();
		} catch (Exception e) {
			new BadRequestException("error");
		}
		return list;
	}
}
