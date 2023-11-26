package call_stored_procedure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

public class StoredProcedure 
{
	private static String url = "jdbc:postgresql://localhost:5432/personal_information"; // we made it private so that this url is not accessable to others 
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
			cnt = DriverManager.getConnection(url, p);
//			CallableStatement precall = cnt.prepareCall("CALL insert_data(?,?)");    with delemeters
//			precall.setString(1, "XXX");
//			precall.setInt(2, 12345);
			
			CallableStatement precall = cnt.prepareCall("CALL insert_data('XXX',12345)"); // without delemeters.
			
			precall.execute();
			System.out.println("Data inserted");
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(cnt!=null)
			{
				try {
					cnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
