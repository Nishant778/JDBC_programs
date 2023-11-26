package Display_result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Display_result 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project?user=postgres&password=root");
			Statement stmt = cnt.createStatement();
			boolean execute = stmt.execute("SELECT * FROM student ");
			
			if(execute)
			{
				System.out.println("Record exisit");
				ResultSet rs = stmt.getResultSet();
				while(rs.next())
				{
					System.out.println();
					System.out.println("ID: "+rs.getInt(1));
					System.out.println("Name: "+rs.getString(2));
				}
			}
			else
			{
				System.out.println("Record doesnt exist");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
