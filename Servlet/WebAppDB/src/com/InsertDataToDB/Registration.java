package com.InsertDataToDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter out= resp.getWriter();
		String cname = req.getParameter("user");
		String emailId = req.getParameter("mail");
		String password= req.getParameter("pswd");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.dbConnection();
			
			// 3. Issues SQL queries via Connection
			pstmt = con.prepareStatement("insert into customer_info values(?,?,?)");
			
			pstmt.setString(1, cname);
			pstmt.setString(2, emailId);
			pstmt.setString(3, password);
			
			int count= pstmt.executeUpdate();
			
			// 4. Process The results Returned by SQL queries
			
			if(count==1){
				out.print(cname+"<font style=color:blue> Your data is Inserted</font>");
			}
			else{
				out.print("<font style=color:red>Your data is not Inserted</font>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
