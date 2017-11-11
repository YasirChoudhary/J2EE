package com.RequestDispacth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidation extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= resp.getWriter();
		
		String customer= req.getParameter("UserId");
	String	password=req.getParameter("pswd");
	
	req.setAttribute("users", customer);
		RequestDispatcher dispatcher;
		
		if(customer.equals("Yasir") && password.equals("1234")){
			dispatcher=req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
			
			
		}
		
	}

}
