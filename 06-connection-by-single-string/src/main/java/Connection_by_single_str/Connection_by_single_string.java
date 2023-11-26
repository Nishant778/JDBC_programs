package Connection_by_single_str;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection_by_single_string 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project?user=postgres&password=root");
			Statement stmt = cnt.createStatement();
			stmt.execute("INSERT INTO student VALUES(6,'Mala Soren')");
			cnt.close();
			System.out.println("Data usccessfully deleted");
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
