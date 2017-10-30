
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sample3PreparedStmt {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. get the database connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/studentapp?user=root&password=yasir";
			con = DriverManager.getConnection(dbUrl);
			
			// 3. Issues the SQL queries
			pstmt = con.prepareStatement("insert into studentdetails values(?,?,?,?)");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			pstmt.setLong(4, Long.parseLong(args[3]));
			
			int count = pstmt.executeUpdate();
			
			// 4. process the results returned by sql queries
			if(count==1){
				System.out.println("Data is inserted successfully");
			}
			else{
				System.err.println("Data is not inserted successfully");
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
					if(pstmt!=null){
						pstmt.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
