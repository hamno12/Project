package com.iTeyes.Spring.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iTeyes.Spring.vo.BoardVo;

@Repository("boardDao")
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<?> selectboardList(Map<String, Object> paraMap) {
		return sqlSession.selectList("board.selectBoardList", paraMap);
	}

	public BoardVo selectBoardOne(Map<String, Object> paraMap) {
		return sqlSession.selectOne("board.selectBoardOne", paraMap);
	}
	
	public int BoardDelete(Map<String, Object> paraMap) {
		return sqlSession.delete("board.boardDelete", paraMap);
	}
	
	public int BoardInsert(Map<String, Object> paraMap) {
		return sqlSession.insert("board.boardInsert", paraMap);
	}
	
	public int BoardUpdate(Map<String, Object> paraMap) {
		return sqlSession.update("board.boardUpdate", paraMap);
	}
	
}
