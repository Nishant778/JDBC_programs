package Insert_using_PreparedStmt;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class PreparedStmt 
{
	public static void main(String[] args) 
	{
		try 
		{
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			
			FileInputStream fis = new FileInputStream("dbconfig.properties");
			Properties p = new Properties();
			p.load(fis);
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project",p);
			
			String query = "INSERT INTO student VALUES(?,?);";
			PreparedStatement pstmt = cnt.prepareStatement(query);
			pstmt.setInt(1,8 );
			pstmt.setString(2, "ZZZ");
			System.out.println("Data entered");
			
			pstmt.execute();
			
			cnt.close();			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
