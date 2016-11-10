package com.study.myhome.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartRequest;

import com.study.myhome.board.service.BoardService;
import com.study.myhome.board.service.BoardVO;
import com.study.myhome.common.util.ListObject;
import com.study.myhome.common.util.ListObjectImpl;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private EgovFileMngUtil egovFileMngUtil;
	
	@Autowired
	private EgovFileMngService fileMngService;
	
	/**
	 * 게시판 리스트
	 */
	public ListObject<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		List<BoardVO> list = boardDAO.selectBoardList(boardVO);
		int totalCount = boardDAO.selectBoardListCnt(boardVO);
		ListObject<BoardVO> listObj = new ListObjectImpl<BoardVO>(list, totalCount);
		return listObj;
	}
	
	/**
	 * 게시판 조회
	 */
	public BoardVO selectBoardArticle(BoardVO boardVO) throws Exception {
		boardVO = boardDAO.selectBoardArticle(boardVO);
		boardVO.setFiles(fileMngService.selectFileInfs(new FileVO(boardVO.getAtchFileId())));
		return boardDAO.selectBoardArticle(boardVO);
	}
	
	/**
	 * 게시글 수정
	 */
	public void updateBoardArticle(MultipartRequest multipartRequest, BoardVO boardVO) throws Exception {
		
		if(!multipartRequest.getFileMap().isEmpty()) {
			List<FileVO> files = egovFileMngUtil.parseFileInf(multipartRequest.getFileMap(), "", 0, "", "");
			boardVO.setAtchFileId(files);
		}
		
		boardDAO.updateBoardArticle(boardVO);	
	}
	
	/**
	 * 게시글 삭제
	 */
	public void deleteBoardArticle(BoardVO boardVO) throws Exception {
		boardDAO.deleteBoardArticle(boardVO);
	}
	
	/**
	 * 게시글 등록
	 */
	public void insertBoardArticle(MultipartRequest multipartRequest, BoardVO boardVO) throws Exception {
		
		List<FileVO> files = egovFileMngUtil.parseFileInf(multipartRequest.getFileMap(), "", 0, "", "");
		
		if(files != null && !files.isEmpty()) {
			// 파일 처리
			fileMngService.insertFileInfs(files);
		}
		boardVO.setAtchFileId(files);
		// 게시글 등록
		boardDAO.insertBoardArticle(boardVO);
	}
}
