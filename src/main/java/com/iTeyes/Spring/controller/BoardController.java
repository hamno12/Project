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

import com.iTeyes.Spring.service.BoardService;
import com.iTeyes.Spring.vo.BoardVo;

@Controller
public class BoardController {
	@Resource(name = "boardService")
	private BoardService boardService;

	@RequestMapping(value = "/boardList")
	public String boardList(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		// System.out.println("boardList");
		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<?> boardList = boardService.selectBoardList(paramMap);
		modelMap.addAttribute("boardList", boardList);
		return "boardList";
	}

	@RequestMapping(value = "/boardOne")
	public String boardOne(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		String boardNo = request.getParameter("boardNo");
		paramMap.put("boardNo", boardNo);		
		BoardVo vo = boardService.selectBoardOne(paramMap);
		modelMap.addAttribute("vo", vo);

		return "boardOne";
	}
	
	@RequestMapping(value = "/updateForm")
	public String UpdateForm(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		System.out.println("////////////////////////////Form까지는 넘어 왔다///////////////////////////");
		String boardNo = request.getParameter("boardNo");
		paramMap.put("boardNo", boardNo);		
		BoardVo vo = boardService.selectBoardOne(paramMap);
		modelMap.addAttribute("vo", vo);

		return "insertForm";
	}
	
	   @RequestMapping(value="insertForm")
	   public String boardWrite(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
	      return "insertForm";
	   }
	   
	
	@RequestMapping(value = "/boardDelete")
	public String boardDelete(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		System.out.println("////////////////////////////Delete까지는 넘어 왔다///////////////////////////");
		String boardNo = request.getParameter("boardNo");
		paraMap.put("boardNo", boardNo);		
	    boardService.BoardDelete(paraMap);
		return "redirect:/boardList";
	}
	
	@RequestMapping(value = "/boardInsert")
	public String boardInsert(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String boardTitle = request.getParameter("boardTitle");
		String boardContents = request.getParameter("boardContents");
		
		paramMap.put("boardTitle", boardTitle);
		paramMap.put("boardContents", boardContents);
		boardService.BoardInsert(paramMap);	
		return  "redirect:/boardList";
	}
	
	@RequestMapping(value = "/boardUpdate")
	public String boardUpdate(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		System.out.println("////////////////////////////Update까지는 넘어 왔다///////////////////////////");
		String boardNo = request.getParameter("boardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContents = request.getParameter("boardContents");
		paraMap.put("boardTitle", boardTitle);
		paraMap.put("boardContents", boardContents);
		paraMap.put("boardNo", boardNo);
		 System.out.println("========================================="+boardNo+" "+boardTitle+boardContents+"=============================================================");
	    boardService.BoardUpdate(paraMap);	
		return "redirect:/boardList";
	}	
}
