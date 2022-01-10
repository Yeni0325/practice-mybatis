package com.ye.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ye.mybatis.board.model.service.BoardServiceImpl;
import com.ye.mybatis.board.model.vo.Board;
import com.ye.mybatis.common.model.vo.PageInfo;
import com.ye.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// -------- 페이징 처리 --------
		int listCount = new BoardServiceImpl().selectListCount();				// 현재 총 게시글 갯수
		int currentPage = Integer.parseInt(request.getParameter("cpage"));		// 현재 페이지 (즉, 사용자가 요청한 페이지)												// 한 페이지내에 보여질 게시글 최대갯수 (몇개 단위씩)
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);  // (listCount, currentPage, pageLimit, boardLimit)
		
		ArrayList<Board> list = new BoardServiceImpl().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
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
