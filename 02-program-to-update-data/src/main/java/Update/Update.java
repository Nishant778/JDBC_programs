package Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update 
{
	public static void main(String args[])
	{
		String url = "jdbc:postgresql://localhost:5432/my_first_jdbc_project";
		String user = "postgres";
		String password = "root";
		
		try
		{
			//1. Load or Register Driver
			Class.forName("org.postgresql.Driver");
			
			//2. Establish connection
			Connection cnt = DriverManager.getConnection(url,user,password);
			
			//3. Creatation of Statement
			Statement statement = cnt.createStatement();	
			
			//4. Excute Statement
			statement.execute("UPDATE student SET name = 'Damon Salvatore' WHERE id=2");
			
			//5. Close connection
			cnt.close();
			
			System.out.println("Data updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
