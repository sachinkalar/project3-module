package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModelHibImp;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet{
	private static final String OP_SEARCH = "Search";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo =1;
		int pageSize= 10;
		List list = null;
		
		String op =	req.getParameter("operation");
		
		UserModelHibImp userModel = new UserModelHibImp();
		UserDTO dto = new UserDTO();
		
		try {
			list  = userModel.search(dto, pageNo, pageSize);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageNo", pageNo);
		req.setAttribute("pageSize", pageSize);
		
		RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	int pageNo=1;
	int pageSize = 10;
	List list = null;
		
	String op =	req.getParameter("operation");
	
	
		
		UserModelHibImp userModel = new UserModelHibImp();
		UserDTO dto = new UserDTO();
		
		dto.setFirstName(req.getParameter("FirstName"));
		
		if(OP_SEARCH.equalsIgnoreCase(op)) {
			pageNo=1;
		}
		
			try {
				list = userModel.search(dto, pageNo, pageSize);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("list", list);
			req.setAttribute("pageNo", pageNo);
			req.setAttribute("pageSize", pageSize);
			
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);		
		
		
		
		
		
		
		
	}
	

}
