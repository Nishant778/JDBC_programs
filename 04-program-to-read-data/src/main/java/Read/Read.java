package Read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read 
{
	public static void main(String[] args) 
	{
		String url = "jdbc:postgresql://localhost:5432/my_first_jdbc_project"; 
		String user = "postgres";
		String password = "root";
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection cnt = DriverManager.getConnection(url,user,password);
			
			Statement stmt = cnt.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM student where id=1");
			
			while(rs.next())
			{
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				
			}
		}
		
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		
	}
}
