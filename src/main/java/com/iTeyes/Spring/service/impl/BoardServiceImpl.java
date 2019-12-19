package com.iTeyes.Spring.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iTeyes.Spring.dao.BoardDao;
import com.iTeyes.Spring.service.BoardService;
import com.iTeyes.Spring.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Resource(name = "boardDao")
	private BoardDao boardDao;

	@Override
	public List<?> selectBoardList(Map<String, Object> paraMap) {
		return boardDao.selectboardList(paraMap);
	}

	@Override
	public BoardVo selectBoardOne(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardOne(paraMap);
	}
	
	public int BoardDelete(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		return boardDao.BoardDelete(paraMap);
	}
	
	public int BoardInsert(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		return boardDao.BoardInsert(paraMap);
	}
	
	public int BoardUpdate(Map<String, Object> paraMap) {
		// TODO Auto-generated method stub
		return boardDao.BoardUpdate(paraMap);
	}
}
