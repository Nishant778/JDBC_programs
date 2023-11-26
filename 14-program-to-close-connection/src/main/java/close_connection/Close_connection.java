package close_connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class Close_connection 
{
	public static void main(String[] args) 
	{
		Driver d = new Driver();
		
		Connection cnt = null;
		try 
		{
			DriverManager.registerDriver(d);			
			FileInputStream fis = new FileInputStream("dbconfig.properties");
			Properties p = new Properties();
			p.load(fis);
			cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project", p);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			if(cnt!=null)
			{
				try {
					cnt.close();
					System.out.println("Connection closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
