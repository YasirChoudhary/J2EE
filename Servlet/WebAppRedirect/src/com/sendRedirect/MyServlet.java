package com.sendRedirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter out= resp.getWriter();
		resp.sendRedirect("http://localhost:8080/WebAppRedirect/sar");
	}

}
