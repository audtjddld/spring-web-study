package com.study.myhome.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.study.myhome.board.service.BoardVO;
import com.study.myhome.common.service.impl.CommonDAO;

@Repository
public class BoardDAO extends CommonDAO {
	
	/**
	 * 리스트 조회
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		return sessionTemplate.selectList("BoardDAO.selectBoardList", boardVO);
	}
	
	/**
	 * 리스트 갯수
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public int selectBoardListCnt(BoardVO boardVO) throws Exception {
		return sessionTemplate.selectOne("BoardDAO.selectBoardListCnt", boardVO);
	}
	
	/**
	 * 게시글 상세
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	public BoardVO selectBoardArticle(BoardVO boardVO) throws Exception {
			   sessionTemplate.update("BoardDAO.updateBoardArticleCnt", boardVO);
		return sessionTemplate.selectOne("BoardDAO.selectBoardArticle", boardVO);
	}
	
	/**
	 * 게시판 수정
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void updateBoardArticle(BoardVO boardVO) throws Exception {
		sessionTemplate.update("BoardDAO.updateBoardArticle", boardVO);
	}
	
	/**
	 * 게시글 삭제
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void deleteBoardArticle(BoardVO boardVO) throws Exception {
		sessionTemplate.update("BoardDAO.deleteBoardArticle", boardVO);
	}
	
	/**
	 * 게시글 입력
	 * @author 정명성
	 * @create date : 2016. 11. 7.
	 * @param boardVO
	 * @throws Exception
	 */
	public void insertBoardArticle(BoardVO boardVO) throws Exception {
		sessionTemplate.insert("BoardDAO.insertBoardArticle", boardVO);
	}
}
