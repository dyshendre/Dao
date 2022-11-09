package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ToInsertStudent {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter the roll no :");
		int roll = sc.nextInt();

		System.out.println("enter the name :");
		String name = sc.next();
		
		System.out.println("enter the address :");
		String ad = sc.next();
		
		System.out.println("enter the mobile:");
		String mob = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint4", "root", "aman")) {

			PreparedStatement ps = conn.prepareStatement("insert into student values (?,?,?,?)");
			
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setString(3, ad);
			ps.setString(4, mob);
			
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
