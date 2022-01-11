package com.ye.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.board.model.vo.Reply;
import com.ye.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		
		// 마이바티스에서는 페이징 처리를 위해 RowBounds 클래스 제공
		// * offset : 몇 개의 게시글 건너뛰고 조회할건지에 대한 값
		/*
		 * ex) 현재 boardLimit : 5
		 *  										offset(건너뛸숫자)		limit(조회할숫자)
		 * currentPage : 1 (현재 페이지가 1인 상황)  1~5			0					5       : 0개의 게시글 건너 뛰고 5개를 조회
		 * currentPage : 2 (현재 페이지가 2인 상황)  6~10			5					5       : 5개의 게시글 건너 뛰고 5개를 조회
		 * currentPage : 3 (현재 페이지가 3인 상황)  11~15			10					5		: 10개의 게시글 건너 뛰고 5개를 조회 
		 * ...
		 * 
		 * 즉, 조회할숫자는 boardLimit과 동일!
		 * 그러나 offset은 사용자가 몇번 페이지를 요청하느냐에 따라서 계속 달라짐
		 */
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplylist", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
	
	
	
}
