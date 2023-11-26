package Delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete 
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
			
			stmt.execute("DELETE FROM student WHERE id=4");
			
			cnt.close();
			
			System.out.println("Data deleted");
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
