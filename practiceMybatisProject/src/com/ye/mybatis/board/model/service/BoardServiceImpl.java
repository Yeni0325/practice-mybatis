package com.ye.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ye.mybatis.board.model.dao.BoardDao;
import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.board.model.vo.Reply;
import com.ye.mybatis.common.model.vo.PageInfo;

import static com.ye.mybatis.common.template.Template.*;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao bDao = new BoardDao();
	
	
	@Override
	public int selectListCount() {
		
		SqlSession sqlSession = getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list; // 한 행도 조회되지 않을 경우 텅빈 리스트 반환
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
		
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		Board b = bDao.selectBoard(sqlSession, boardNo);
		sqlSession.close();
		return b;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Reply> list = bDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return list;
		
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return searchCount;
		
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	}

}
