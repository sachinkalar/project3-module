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

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final String OP_LOGIN = "Login";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = null;

		String op = req.getParameter("operation");

		UserModelHibImp UserModel = new UserModelHibImp();

		if (OP_LOGIN.equalsIgnoreCase(op)) {

			UserDTO dto = new UserDTO();

			dto.setLoginId(req.getParameter("LoginId"));
			dto.setPassword(req.getParameter("Password"));

			
				dto = UserModel.authenticate(dto.getLoginId(), dto.getPassword());
			if (dto != null) {
				RequestDispatcher rd = req.getRequestDispatcher("LoggedIn.jsp");
				rd.forward(req, resp);

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("InvalidLogin.jsp");
				rd.forward(req, resp);
			}

		}

	}
}
