package PreparedStmt_n_records;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.Driver;

public class PreparedStmt_n_records 
{
	static int id;
	static String name;
	static Scanner sc = new Scanner(System.in);
	static int n;
	public static void main(String[] args) 
	{
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project?user=postgres&password=root");
			
			PreparedStatement pstmt = cnt.prepareStatement("INSERT INTO student VALUES(?,?);");
			System.out.println("Enter numberof inputs:");
			n = sc.nextInt();
			while(n>0)
			{
				System.out.println("Enter id: ");
				id = sc.nextInt();
				System.out.println("Enter name: ");
				name = sc.next();
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				System.out.println("Data entered");
				pstmt.execute();
				n--;
			}
			System.out.println("Thank you");
			cnt.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
