package com.ye.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ye.mybatis.board.model.service.BoardService;
import com.ye.mybatis.board.model.service.BoardServiceImpl;
import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.common.model.vo.PageInfo;
import com.ye.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String condition = request.getParameter("condition"); // "writer"|"title"|"content"
		String keyword = request.getParameter("keyword");	  // "사용자가 입력한 키워드값"
		
		HashMap<String, String> map = new HashMap<>(); // hashMap의 특징 -> 보따리 같은 공간으로, 순서가 없고, key-value세트로 담음
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		
		BoardService bService = new BoardServiceImpl();
		int searchCount = bService.selectSearchCount(map); // 현재 검색 결과에 맞는 게시글 총갯수 
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, 10, 5);
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		// 검색요청 후 검색했었던 검색 조건과 입력한 키워드를 담아서 해당 페이지로 이동
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
