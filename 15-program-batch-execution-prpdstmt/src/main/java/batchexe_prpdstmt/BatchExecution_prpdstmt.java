package batchexe_prpdstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExecution_prpdstmt 
{
	public static void main(String[] args) 
	{
		String url = "jdbc:postgresql://localhost:5432/personal_information";
		String user= "postgres";
		String password = "root";
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt = DriverManager.getConnection(url,user,password);
			
			String query = "INSERT INTO details VALUES(?,?)";
			PreparedStatement pstmt = cnt.prepareStatement(query);
			pstmt.setString(1, "XXX");
			pstmt.setInt(2, 96321);
			pstmt.addBatch();			
			pstmt.executeBatch();
			System.out.println("Done");
			
			cnt.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
