

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignRetriveData {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet dbResult = null;
		
		try {
			// 1. load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. get the DB connection via Driver
			String dburl="jdbc:mysql://localhost:3306/school_db?user=root&password=yasir";
			con = DriverManager.getConnection(dburl);
			
			// 3. Issues sql queries
			stmt = con.createStatement();
			String query = "Select * from gardian_info inner join student_info on gardian_info.Regno=student_info.Regno "
					+ "inner join student_otherinfo on student_info.Regno=student_otherinfo.Regno ";
			dbResult = stmt.executeQuery(query);
			
			// 4. Process the results Returned by sql Queries
			while(dbResult.next()){
				int regno = dbResult.getInt("Regno");
				String gfname = dbResult.getString("GFirstName");
				String mname = dbResult.getString("GMiddleName");
				String lname = dbResult.getString("GLastName");
				int regno2 = dbResult.getInt("Regno");
				String sFname = dbResult.getString("FirstName");
				String sMname = dbResult.getString("MiddleName");
				String sLname = dbResult.getString("LastName");
				int regno3 = dbResult.getInt("Regno");
				String isAdmin = dbResult.getString("IsAdmin");
				String password = dbResult.getString("Password");
				
				System.out.println(regno+" "+gfname+" "+mname+" "+lname+" "+regno2+" "+sFname+" "+sMname+" "+sLname+" "+regno3+" "+isAdmin+" "+password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			try {
				if(con!=null){
				con.close();
				}
				if(stmt!=null){
					stmt.close();
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
