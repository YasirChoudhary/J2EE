
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample1 {
	public static void main(String[] args) {
		Connection con = null;
        Statement stmt = null;
        ResultSet dbResult = null;
		try {
			//1. Load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. get the db connection via driver
			String dburl="jdbc:mysql://localhost:3306/school?user=root&password=yasir";
			con = DriverManager.getConnection(dburl);
			
			// 3. Issues the sql queries
			stmt = con.createStatement();
			String query = "Select * from student";
			dbResult = stmt.executeQuery(query);
			
			// 4. Process the result returned by sql queries
			while(dbResult.next()){
				int id = dbResult.getInt("SId");
				String name = dbResult.getString("SName");
				int age = dbResult.getInt("Age");
				String branch = dbResult.getString("Branch");
				int marks = dbResult.getInt("Marks");
				
				System.out.println(id+" "+name+" "+age+" "+branch+" "+marks+" ");
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
