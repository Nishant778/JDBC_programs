package Batch_execution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class Batch_execution 
{
	public static void main(String[] args) 
	{
		Driver d = new Driver();
		try 
		{
			DriverManager.registerDriver(d);
			
			FileInputStream fis = new FileInputStream("dbconfig.properties");
			Properties p = new Properties();
			p.load(fis);
			
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project", p);
			
			Statement stmt = cnt.createStatement();
			stmt.addBatch("INSERT INTO student VALUES(9,'Akash')");
			stmt.addBatch("INSERT INTO student VALUES(10,'Omkar')");
			stmt.addBatch("INSERT INTO student VALUES(11,'Aditi')");
			stmt.addBatch("INSERT INTO student VALUES(12,'Maitri')");
			
			int[] executeBatch = stmt.executeBatch();
						
			for (int i = 0; i < executeBatch.length; i++) 
			{
				System.out.println("No. of rows affected: "+executeBatch[i]);
			}
			cnt.close();	
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
		
	}
}
