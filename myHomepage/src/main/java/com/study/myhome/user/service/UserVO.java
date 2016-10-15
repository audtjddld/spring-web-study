package com.study.myhome.user.service;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.study.myhome.common.service.Pageable;

@Alias("UserVO")
public class UserVO extends Pageable {

	// @Size(min = 4, max = 10)
	@NotNull
	private String username;

	@NotNull
	private String password;

	private Date joinDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public UserVO() {
		this.joinDate = new Date();
	}

	public UserVO(String username, String password) {
		this.username = username;
		this.password = password;
		this.joinDate = new Date();
	}

}
