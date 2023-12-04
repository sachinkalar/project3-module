package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModelHibImp;

@WebServlet("/UpdateCtl")
public class UpdateCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String op =	req.getParameter("operation");
	
	UserModelHibImp userModel = new UserModelHibImp();
	
	UserDTO dto = new UserDTO();
	
    int id = Integer.parseInt(req.getParameter("id"));
    
    try {
		dto = userModel.findByPk(id);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("UpdateView.jsp");
		rd.forward(req, resp);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	RequestDispatcher rd = req.getRequestDispatcher("UpdateView.jsp");
	rd.forward(req, resp);
	
	
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
