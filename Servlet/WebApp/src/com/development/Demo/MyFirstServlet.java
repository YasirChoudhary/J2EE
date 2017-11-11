package com.development.Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date d = new Date();
		
		String todaysDate="<html>"
				+ "<h1>Todays date:<font style = color:red>"+d.toString()
				+ "</font></h1></html>";
		
		PrintWriter out = resp.getWriter();
		out.print(todaysDate);
	}

}
