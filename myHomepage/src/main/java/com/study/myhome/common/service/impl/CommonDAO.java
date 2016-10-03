package com.study.myhome.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDAO {
	
	@Autowired
	protected SqlMapClient sqlTempate;
	
}
