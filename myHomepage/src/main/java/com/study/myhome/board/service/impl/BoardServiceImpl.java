package com.study.myhome.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.myhome.board.service.BoardService;
import com.study.myhome.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	public Map<String, Object> selectBoardList(BoardVO boardVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", boardDAO.selectBoardList(boardVO));
		resultMap.put("totalCnt", boardDAO.selectBoardListCnt(boardVO));
		return resultMap;
	}
	
	public BoardVO selectBoardArticle(BoardVO boardVO) throws Exception {
		return boardDAO.selectBoardArticle(boardVO);
	}
	
	public void updateBoardArticle(BoardVO boardVO) throws Exception {
		boardDAO.updateBoardArticle(boardVO);
	}
	
	public void deleteBoardArticle(BoardVO boardVO) throws Exception {
		boardDAO.deleteBoardArticle(boardVO);
	}
	
	public void insertBoardArticle(BoardVO boardVO) throws Exception {
		boardDAO.insertBoardArticle(boardVO);
	}
}
