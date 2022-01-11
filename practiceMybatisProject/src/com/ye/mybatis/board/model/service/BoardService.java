package com.ye.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.board.model.vo.Reply;
import com.ye.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 조회
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 상세조회
	int increaseCount(int boardNo);
	Board selectBoard(int boardNo);
	ArrayList<Reply> selectReplyList(int boardNo);
	
	// 게시글검색
	int selectSearchCount(HashMap<String,String> map);
	ArrayList<Board> selectSearchList(HashMap<String,String> map, PageInfo pi);
	
}
