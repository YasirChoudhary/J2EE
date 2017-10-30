
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AssignmentPreparedStmt {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		
		try {
			// It is not successfully executed because it insert the first row data in all column.
			
			// 1. load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. Get the db connection via driver
			String dburl = "jdbc:mysql://localhost:3306/school_db?user=root&password=yasir";
			con = DriverManager.getConnection(dburl);
			
			// 3. Issues sql queries
			pstmt = con.prepareStatement("insert into gardian_info values(?,?,?,?)");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setString(3, args[2]);
			pstmt.setString(4, args[3]);
			
			int count1 = pstmt.executeUpdate();
			
			pstmt2 = con.prepareStatement("insert into student_info values(?,?,?,?)");
			pstmt2.setInt(1, Integer.parseInt(args[0]));
			pstmt2.setString(2, args[1]);
			pstmt2.setString(3, args[2]);
			pstmt2.setString(4, args[3]);
			
			int count2 = pstmt2.executeUpdate();
			
			pstmt3 = con.prepareStatement("insert into student_otherinfo values(?,?,?)");
			pstmt3.setInt(1, Integer.parseInt(args[0]));
			pstmt3.setString(2, args[1]);
			pstmt3.setString(3, args[2]);
			
			int count3 = pstmt.executeUpdate();
			
			// process the results returned by sql queries
			if(count1==1){
				System.out.println("Gardian info succsesfully added");
			}
			else{
				System.err.println("Gardian info not added");
			}
			if(count2==1){
				System.out.println("student info succsesfully added");
			}
			else{
				System.err.println("student info not  added");
			}
			if(count3==1){
				System.out.println("student Otherinfo succsesfully added");
			}
			else{
				System.err.println("student Otherinfo not  added");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5. close all jdbc objects
		finally{
			
				try {
					if(con!=null){
					con.close();
					if(pstmt!=null){
						pstmt.close();
					}
					if(pstmt2!=null){
						pstmt.close();
					}
					if(pstmt3!=null){
						pstmt.close();
					}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
	}

}
