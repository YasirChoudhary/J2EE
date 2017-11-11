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
		
		RequestDispatcher dispatcher;
		
		if(customer.equals("India") && password.equals("1234")){
			dispatcher=req.getRequestDispatcher("HomePage.html");
			dispatcher.forward(req, resp);
			
		}
		else{
			// For Forward
			dispatcher=req.getRequestDispatcher("ErrorPage.html");
			dispatcher.forward(req, resp);
			
			// for include
			//out.print("<h1><font style=color:red>Invalid Username/Password</font></h1>");
			//dispatcher=req.getRequestDispatcher("LoginPage.html");
			//dispatcher.include(req, resp);
		}
		
	}

}
