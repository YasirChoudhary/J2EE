package com.NonPersistence;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NonPersistence extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out=resp.getWriter();
		
		String user=req.getParameter("UserId");
		String pasword=req.getParameter("pswd");
		
		Cookie cookie=new Cookie(user, pasword);
		// cookie.setMaxAge(30*30);
		resp.addCookie(cookie);
		
		out.print("hi......"+user);
	}

}
