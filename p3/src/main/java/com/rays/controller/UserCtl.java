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

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserModelHibImp userModel = new UserModelHibImp();
		UserDTO dto = new UserDTO();
		
	String id = req.getParameter("id");
	
	dto.setId(Integer.parseInt(id));
	
	try {
		userModel.delete(dto);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	RequestDispatcher rd = req.getRequestDispatcher("DeleteView.jsp");
	rd.forward(req, resp);
   
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
