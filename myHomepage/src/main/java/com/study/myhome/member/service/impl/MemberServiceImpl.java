package com.study.myhome.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.myhome.member.service.MemberService;
import com.study.myhome.user.service.UserVO;

@Service
public class MemberServiceImpl implements MemberService {

	/* (non-Javadoc)
	 * @see com.study.myhome.member.service.impl.MemberService#getMembers()
	 */
	public List<UserVO> getMembers() {

		List<UserVO> list = new ArrayList();
		for (int i = 0; i < 20; i++) {
			UserVO user = new UserVO();
			user.setUsername("user" + i);
			user.setPassword("1234" + i);

			list.add(user);
		}
		return list;
	}
}
