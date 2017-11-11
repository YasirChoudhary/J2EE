package com.jspiders;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter out= resp.getWriter();
		
		ServletContext app= getServletContext();
		String s1= app.getInitParameter("jspider");
		String s2 = app.getInitParameter("Qspider");
		
		out.print(s1);
		out.print(s2);
	}
}