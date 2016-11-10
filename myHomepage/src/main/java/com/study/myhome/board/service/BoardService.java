package com.study.myhome.board.service;

import org.springframework.web.multipart.MultipartRequest;

import com.study.myhome.common.util.ListObject;

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
	public ListObject<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;

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
	public void updateBoardArticle(MultipartRequest multipartRequest, BoardVO boardVO) throws Exception;

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
	 * @param mutipartRequest 
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void insertBoardArticle(MultipartRequest mutipartRequest, BoardVO boardVO) throws Exception;

}