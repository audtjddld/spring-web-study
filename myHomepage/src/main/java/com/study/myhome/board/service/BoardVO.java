package com.study.myhome.board.service;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.study.myhome.common.service.Pageable;

@Alias("BoardVO")
public class BoardVO extends Pageable {
	private Long idx;

	private String title;

	private String content;

	private int view_cnt = 0;

	private String use_yn = "Y";

	private String atchFileId;

	private Date regdate;
	
	{
		regdate = new Date();
	}
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Long getIdx() {
		return idx;
	}

	public BoardVO() {

	}

	public BoardVO(String title, String content, String atchFileId) {
		super();
		this.title = title;
		this.content = content;
		this.atchFileId = atchFileId;
	}

	public BoardVO(Long idx, String title, String content, String atchFileId) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.atchFileId = atchFileId;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

}
