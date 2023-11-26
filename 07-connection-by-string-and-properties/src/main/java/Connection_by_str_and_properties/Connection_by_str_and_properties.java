package Connection_by_str_and_properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//We are not using double quotes because here we are passing data as key-value pairs

public class Connection_by_str_and_properties 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");

			//inside the maven project: ctrl+n>files>choose general>in filename: dbconfig.properties (we can give any name)
			
			FileInputStream FIS = new FileInputStream("dbconfig.properties");
			Properties p = new Properties();
			p.load(FIS);
			
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project", p );
			
			Statement stmt = cnt.createStatement();
			
			stmt.execute("INSERT INTO student VALUES(7,'ABCD')");
			
			cnt.close();
			
			System.out.println("Data entered successfully");

		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
