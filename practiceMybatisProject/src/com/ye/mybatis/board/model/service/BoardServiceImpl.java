package com.ye.mybatis.board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ye.mybatis.board.model.dao.BoardDao;
import com.ye.mybatis.board.model.vo.Board;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
