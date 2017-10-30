
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample2 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			// 1. Load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. get the Database connection via driver
			String url = "jdbc:mysql://localhost:3306/school";
			String user="root";
			String password="yasir";
			con = DriverManager.getConnection(url, user, password);
			
			// 3. Issues the sql querie
			stmt = con.createStatement();
			String query = "insert into student values(9,'Rahul',22,'EXTC',65)";
			int count = stmt.executeUpdate(query);
			
			// 4.process the result returned by sql quries 
			if (count==1){
				System.out.println("Data is inserted successfully");
			}
			else{
				System.err.println("Data is not inserted");
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
