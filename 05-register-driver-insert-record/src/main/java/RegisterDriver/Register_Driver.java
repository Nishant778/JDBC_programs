package RegisterDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.postgresql.Driver;

public class Register_Driver 
{
	public static void main(String[] args) 
	{
		String url = "jdbc:postgresql://localhost:5432/my_first_jdbc_project";
		String user = "postgres";
		String pwd = "root";
		
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);	
			
			Connection cnt = DriverManager.getConnection(url,user,pwd);
			
			Statement stmt = cnt.createStatement();
			
			stmt.execute("INSERT INTO student VALUES(4,'Jyoti Kumari'); INSERT INTO student VALUES(5, 'Debraj Buniya')");
			
			cnt.close();
			
			System.out.println("Datas added to the DB");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
