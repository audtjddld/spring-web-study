package com.study.myhome.common.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonDAO {

	@Autowired
	protected SqlSessionTemplate sessionTemplate;

}
