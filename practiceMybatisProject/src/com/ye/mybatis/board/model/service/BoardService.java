package com.ye.mybatis.board.model.service;

import java.util.ArrayList;

import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	
}
