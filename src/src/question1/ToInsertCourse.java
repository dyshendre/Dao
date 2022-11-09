package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ToInsertCourse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the course id :");
		int cid = sc.nextInt();

		System.out.println("enter the course name :");
		String cname = sc.next();
		
		System.out.println("enter the fee :");
		int fee = sc.nextInt();
		
		System.out.println("enter the duration:");
		String dura = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint4", "root", "aman")) {

			PreparedStatement ps = conn.prepareStatement("insert into course values (?,?,?,?)");
			
			ps.setInt(1, cid);
			ps.setString(2, cname);
			ps.setInt(3, fee);
			ps.setString(4, dura);
			
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
