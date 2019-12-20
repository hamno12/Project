package com.iTeyes.Spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import com.iTeyes.Spring.service.BoardService;
import com.iTeyes.Spring.vo.BoardVo;

@Controller
public class BoardController {
	@Resource(name = "boardService")
	private BoardService boardService;

	@RequestMapping(value = "/boardList") // 게시판 리스트를 보여주는 Controller
	public String boardList(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<?> boardList = boardService.selectBoardList(paramMap);
		modelMap.addAttribute("boardList", boardList);
		return "boardList";
	}

	@RequestMapping(value = { "/boardOne", "/updateForm" }) // 선택한 글을 상세하게 보여주거나 수정하는 페이지로 가는 Controller
	public String boardOne(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String boardNo = request.getParameter("boardNo");
		paramMap.put("boardNo", boardNo);
		BoardVo vo = boardService.selectBoardOne(paramMap);
		modelMap.addAttribute("vo", vo);

		String requestMapping = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

		if (requestMapping.equals("/boardOne")) {
			return "boardOne";
		} else {
			return "insertForm";
		}
	}

	@RequestMapping(value = "insertForm") // 새로운 글을 작성하는 페이지로 가는 Controller
	public String boardWrite(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		return "insertForm";
	}

	@RequestMapping(value = "/boardDelete") // 선택한 게시판을 Controller
	public String boardDelete(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		String boardNo = request.getParameter("boardNo");
		paraMap.put("boardNo", boardNo);
		boardService.BoardDelete(paraMap);
		return "redirect:/boardList";
	}

	@RequestMapping(value = "/boardWrite") // 게시판 글을 추가하거나 수정하는 Controller
	public String boardUpdate(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		String boardNo = request.getParameter("boardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContents = request.getParameter("boardContents");
		paraMap.put("boardTitle", boardTitle);
		paraMap.put("boardContents", boardContents);
		paraMap.put("boardNo", boardNo);

		if (boardNo.length() == 0) {
			boardService.BoardInsert(paraMap);
		} else {
			boardService.BoardUpdate(paraMap);
		}

		return "redirect:/boardList";
	}
}
