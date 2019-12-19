package com.iTeyes.Spring.service;

import java.util.List;
import java.util.Map;

import com.iTeyes.Spring.vo.BoardVo;

public interface BoardService {
	List<?> selectBoardList(Map<String, Object> paramMap);

	BoardVo selectBoardOne(Map<String, Object> paramMap);
	
	int BoardDelete(Map<String, Object> paramMap);
	
	int BoardInsert(Map<String, Object> paramMap);
	
	int BoardUpdate(Map<String, Object> paramMap);
}
