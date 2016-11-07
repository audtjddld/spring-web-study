package com.study.myhome.board.service;

import java.util.Map;

public interface BoardService {

	/**
	 * 게시글 리스트
	 * 
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectBoardList(BoardVO boardVO) throws Exception;

	/**
	 * 게시글 조회
	 * 
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public BoardVO selectBoardArticle(BoardVO boardVO) throws Exception;

	/**
	 * 게시글 수정
	 * 
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void updateBoardArticle(BoardVO boardVO) throws Exception;

	/**
	 * 게시글 삭제
	 * 
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void deleteBoardArticle(BoardVO boardVO) throws Exception;

	/**
	 * 게시글 입력
	 * 
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void insertBoardArticle(BoardVO boardVO) throws Exception;

}