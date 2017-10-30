

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample4CallableStmt {
	public static void main(String[] args) {
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet dbResult = null;
		
		try {
			// 1. Load the diver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. Get the DB connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/studentapp?user=root&password=yasir";
			con = DriverManager.getConnection(dbUrl);
			
			// 3. Issues the sql queries
			cstmt = con.prepareCall("call getstudentinfo");
			dbResult = cstmt.executeQuery();
			
			// 4. Process the result returned by sql queries
			while(dbResult.next()){
				int regno = dbResult.getInt("regno");
				String studName = dbResult.getString("name");
				String emailId = dbResult.getString("email_id");
				long mobileNo = dbResult.getLong("MobileNo");
				System.out.println(regno+" "+studName+" "+emailId+" "+mobileNo+" ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			// 5. close all jdbc objects
				try {
					if(con!=null){
					con.close();
					}
					if(cstmt!=null){
						cstmt.close();
					}
					if(dbResult!=null){
						dbResult.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}
}
