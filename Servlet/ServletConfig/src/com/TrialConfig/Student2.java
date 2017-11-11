package com.TrialConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter write = resp.getWriter();
		
		ServletConfig config= getServletConfig();
		String s1 =config.getInitParameter("studentName");
		String s2 = config.getInitParameter("Address");
		
	//	String s1 = getInitParameter("studentName");
	//	String s2 = getInitParameter("Address");
		 
		write.print(s1);
		write.print("<br>"+s2);
		
	}
	

}
