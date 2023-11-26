package Execute_Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project?user=postgres&password=root");
			Statement stmt = cnt.createStatement();
			int eq = stmt.executeUpdate("UPDATE student SET name = 'QWERTY' WHERE id = 8");
			System.out.println("Updated Record: "+eq);
			cnt.close();
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
