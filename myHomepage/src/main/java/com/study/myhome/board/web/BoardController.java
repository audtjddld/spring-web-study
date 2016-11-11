package com.study.myhome.board.web;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import com.study.myhome.board.service.BoardService;
import com.study.myhome.board.service.BoardVO;
import com.study.myhome.common.util.ListObject;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
@RequestMapping(value = {"/user", "/manager"})
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/list.do")
	public String boardList(@ModelAttribute BoardVO boardVO, PaginationInfo paginationInfo, ModelMap modelMap) throws Exception {
		
		BeanUtils.copyProperties(paginationInfo, boardVO);

		// list와 전체 페이징 갯수를 가져와야 한다.
		ListObject<BoardVO> listObj = boardService.selectBoardList(boardVO);
		listObj.setPaginationInfo(paginationInfo);
		modelMap.addAttribute("listObj", listObj);
		
		return "board/list.myhome";
	}
	
	@RequestMapping(value = "/board/write.do")
	public String writePage(@ModelAttribute BoardVO boardVO) throws Exception {
		
		return "board/write.myhome";
	}
	
	
	@RequestMapping(value= "/board/view.do")
	public String selectBoardArticle(@ModelAttribute BoardVO boardVO, ModelMap modelMap) throws Exception {
		
		modelMap.addAttribute("info", boardService.selectBoardArticle(boardVO));
		
		return "board/view.myhome";
	}
	
	/**
	 * 수정 페이지
	 * @author 정명성
	 * @create date : 2016. 11. 10.
	 * @param mutipartRequest
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/modify.do")
	public String modifyArticlePage(@ModelAttribute BoardVO boardVO, ModelMap modelMap) throws Exception {
		
		modelMap.addAttribute("info", boardService.selectBoardArticle(boardVO));
		
		return "board/modify.myhome";
	}
	
	/**
	 * 게시물 정보 저장
	 * @author 정명성
	 * @create date : 2016. 11. 10.
	 * @param mutipartRequest
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/insert.do")
	public String insertBoardArticle(MultipartRequest mutipartRequest, @ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.insertBoardArticle(mutipartRequest, boardVO);
		
		return "redirect:./list.do";
	}
	
	/**
	 * 게시물 삭제
	 * @author 정명성
	 * @create date : 2016. 11. 10.
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/board/delete.do")
	public String deleteBoardArticle(@ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.deleteBoardArticle(boardVO);
		
		return "redirect:./list.do";
	}
	
	/**
	 * 게시물 정보 수정
	 * @author 정명성
	 * @create date : 2016. 11. 10.
	 * @param mutipartRequest
	 * @param boardVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/board/update.do")
	public String updateBoardArticle(MultipartRequest multipartRequest, @ModelAttribute BoardVO boardVO) throws Exception {
		
		boardService.updateBoardArticle(multipartRequest, boardVO);
		
		return "redirect:./view.do?idx=" + boardVO.getIdx();
	}
}
