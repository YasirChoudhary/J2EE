package com.PersistanceCookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Persistance extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter write = resp.getWriter();
		String user = req.getParameter("UserId");
		String password= req.getParameter("pswd");
		
		Cookie cookie= new Cookie(user, password);
		cookie.setMaxAge(1200);
		resp.addCookie(cookie);
		
		write.print("Hey ........."+user);
	}

}
