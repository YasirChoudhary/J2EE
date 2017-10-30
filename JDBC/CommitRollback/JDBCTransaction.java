
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {
	public static void main(String[] args) {
		Connection con=null;
		Statement st1=null;
		Statement st2=null;
		try {
			// 1. load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. get the DB connection via driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp?user=root&password=yasir");
			
			con.setAutoCommit(false);
			
			st1 = con.createStatement();
			int count1 = st1.executeUpdate("insert into studentdetails values(8,'Allen','allen@gmail.com',9857628625)");
			
			st2 = con.createStatement();
			int count2=st2.executeUpdate("insert into studentdetails values(9,'akhtar','akhtar@gmail.com',5566555255)");
			
			if((count1==1) & (count2==1)){
				System.out.println("Data inserted successfully");
			}
			con.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				con.rollback();
				System.out.println("Rollback to last Transaction");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally{
				try {
					if(con!=null){
						con.close();
					}
					if(st1!=null){
						st1.close();	
					}
					if(st2!=null){
						st2.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

}
