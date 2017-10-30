
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AssignmntPrepareSt {
	static Scanner sc = new Scanner(System.in);
	static Connection con=null;
	static PreparedStatement pstmt = null;
	public static void main(String[] args) {
		
		
		try {
			// 1. load the driver
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			// 2. Get the db connection via driver
			String dburl = "jdbc:mysql://localhost:3306/school_db?user=root&password=yasir";
			con = DriverManager.getConnection(dburl);
			
			// 3. issues sql queies
			for(int i=1; i<=5; i++){
				System.out.println("---------Enter record number "+i+" in each table-----------");
				addGardianInfo();
				addStudentInfo();
				addStudentOtherInfo();
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
					if(pstmt!=null){
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	
	public static void addGardianInfo(){
		try {
			pstmt = con.prepareStatement("insert into gardian_info values(?,?,?,?)");
			System.out.println("Enter Gardian reg no: ");
			int regno=sc.nextInt();
			
			System.out.println("Enter Gardian First Name: ");
			String fname=sc.next();
			
			System.out.println("Enter Gardian middle name: ");
			String mname=sc.next();
			
			System.out.println("Enter Gardian Last name: ");
			String lname=sc.next();
			
			pstmt.setInt(1, regno);
			pstmt.setString(2, fname);
			pstmt.setString(3, mname);
			pstmt.setString(4, lname);
			
			int count1 =pstmt.executeUpdate();
			
			// 4. process the results returned by sql queries
			if(count1==1){
				System.out.println("---------gardian info inserted----------");
			}
			else{
				System.out.println("---------Gardian info not inserted---------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addStudentInfo(){
		try {
			pstmt = con.prepareStatement("insert into student_info values(?,?,?,?)");
			System.out.println("Enter Student reg no: ");
			int regno=sc.nextInt();
			
			System.out.println("Enter Student First Name: ");
			String fname=sc.next();
			
			System.out.println("Enter Student Middle name: ");
			String mname=sc.next();
			
			System.out.println("Enter Student Last name: ");
			String lname=sc.next();
			
			pstmt.setInt(1, regno);
			pstmt.setString(2, fname);
			pstmt.setString(3, mname);
			pstmt.setString(4, lname);
			
			int count2 =pstmt.executeUpdate();
			// 4. process the results retuned by sql queries
			if(count2==1){
				System.out.println("-------Student info inserted---------");
			}
			else{
				System.out.println("---------Student info not inserted--------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void addStudentOtherInfo(){
		try {
			pstmt= con.prepareStatement("insert into student_otherinfo values(?,?,?)");
			System.out.println("Enter Student_otherInfo regno: ");
			int regno = sc.nextInt();
			
			System.out.println("Student is admin write 'Y' OR 'N': ");
			String isAdmin=sc.next();

			System.out.println("Enter admin Password: ");
			String password=sc.next();
			
			pstmt.setInt(1, regno);
			pstmt.setString(2, isAdmin);
			pstmt.setString(3, password);
			
			int count3 = pstmt.executeUpdate();
			
			// 4. process the results returned by sql queries
			if(count3==1){
				System.out.println("----------Student_OtherInfo inserted----------");
			}
			else{
				System.out.println("----------Student_OtherInfo not inserted----------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
