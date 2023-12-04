package com.rays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.dto.UserDTO;
import com.rays.model.UserModelHibImp;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{
	public static final String OP_SIGN_UP = "SignUp";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("one");
		String op = req.getParameter("operation");
		
		System.out.println("two");
		
		UserModelHibImp userModel = new UserModelHibImp();
		
		System.out.println("three");
		
		UserDTO dto = new UserDTO();
		System.out.println("four");
		
		if(OP_SIGN_UP.equalsIgnoreCase(op)) {
			
			System.out.println("five");
			
			dto.setFirstName(req.getParameter("FirstName"));
		    dto.setLastName(req.getParameter("LastName"));
			dto.setLoginId(req.getParameter("LoginId"));
			dto.setPassword(req.getParameter("Password"));
			dto.setAddress(req.getParameter("Address"));
			
			System.out.println("six");
			
			try {
				userModel.add(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
