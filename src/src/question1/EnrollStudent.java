package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollStudent {

	public static void main(String[] args) {
		
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint4", "root", "aman")) {

		PreparedStatement ps = conn.prepareStatement("insert into student_course values (?,?)");
		
//		ps.setInt(1,30 ); // to enroll amit in java
//		ps.setInt(2, 1);
		
//		ps.setInt(1,30 ); // to enroll amit in spring
//		ps.setInt(2, 2);
		
//		ps.setInt(1,10 ); // to enroll venkat in java
//		ps.setInt(2, 1);
		
//		ps.setInt(1,10 ); // to enroll venkat in react
//		ps.setInt(2, 4);
		
//		ps.setInt(1,50 ); // to enroll raj in spring
//		ps.setInt(2, 2);
		
//		ps.setInt(1,10 ); // to enroll raj in angular
//		ps.setInt(2, 5);
	
//		ps.setInt(1,40 ); // to enroll suresh in java
//		ps.setInt(2, 1);
		
//		ps.setInt(1,40 ); // to enroll suresh in hibernate
//		ps.setInt(2, 3);
		
//		ps.setInt(1,40 ); // to enroll suresh in react
//		ps.setInt(2, 4);
		
		ps.setInt(1,20 ); // to enroll binay in react
		ps.setInt(2, 4);
	int res= 	ps.executeUpdate();
	
	if(res>0) {
		System.out.println("record inserted successfull........");
	}else {
		System.out.println("something went wrong");
	}

	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}

}
	
}
