package com.study.myhome.board.web;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.myhome.board.service.BoardService;
import com.study.myhome.board.service.BoardVO;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board/list.do")
	public String boardList(@ModelAttribute BoardVO boardVO, PaginationInfo paginationInfo, ModelMap modelMap) throws Exception {
		
		BeanUtils.copyProperties(paginationInfo, boardVO);

		// list와 전체 페이징 갯수를 가져와야 한다.
		Map resultMap = boardService.selectBoardList(boardVO);
		// total 갯수
		int totalCnt = (int) resultMap.get("totalCnt");

		// 페이징 된 리스트 갯수
		modelMap.addAttribute("list", resultMap.get("list"));

		paginationInfo.setTotalRecordCount(totalCnt);
		// 페이징 정보
		modelMap.addAttribute("paginationInfo", paginationInfo);
		
		return "board/list.myhome";
	}
	
	
	@RequestMapping(value= "/board/view.do")
	public String selectBoardArticle(@ModelAttribute BoardVO boardVO, ModelMap modelMap) throws Exception {
		
		modelMap.addAttribute("info", boardService.selectBoardArticle(boardVO));
		
		return "board/view.myhome";
	}
	
	@RequestMapping(value = "/board/modify.do")
	public String updatepageBoardArticle(@ModelAttribute BoardVO boardVO) throws Exception {
		
		return "board/modify.myhome";
	}
	
	@RequestMapping(value = "/board/insert.do")
	public String insertBoardArticle(BoardVO boardVO) throws Exception {
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value = "/board/delete.do")
	public String deleteBoardArticle(BoardVO boardVO) throws Exception {
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/update.do")
	public String updateBoardArticle(BoardVO boardVO) throws Exception {
		
		return "redirect:/board/view.do?idx=" + boardVO.getIdx();
	}
}
