package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Getting_details {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the roll_no to whom you want course_detail :");
		int roll = sc.nextInt();
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint4", "root", "aman")) {

			PreparedStatement ps = conn.prepareStatement(" select s.name, c.cid,c.canme,c.fee,c.duration from course c inner join student s inner join  student_course sc on s.rol=sc.rol and c.cid = sc.cid where s.rol = ?");
			
			ps.setInt(1, roll);
			
			
		ResultSet res= 	ps.executeQuery();
		
		while(res.next()) {
			System.out.println("student name is :"+res.getString("name"));
			System.out.println("course id is :"+res.getInt("cid"));
			System.out.println("course fee is :"+res.getInt("fee"));
			System.out.println("course duration is"+res.getString("duration"));
			
			System.out.println("==========================");
		}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}	
		
		
		
	
	
}
