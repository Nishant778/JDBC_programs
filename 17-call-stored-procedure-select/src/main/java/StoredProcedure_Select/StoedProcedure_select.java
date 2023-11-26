package StoredProcedure_Select;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoedProcedure_select
{
	public static void main(String[] args)
	{
		Connection cnt = null;
		try 
		{
			Class.forName("org.postgresql.Driver");
			cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_first_jdbc_project?user=postgres&password=root");
			CallableStatement precall = cnt.prepareCall("CALL select_data(?,?,?)");
			precall.setInt(1, 1);
			precall.registerOutParameter(2, Types.NUMERIC);//Match with the correct type from stored procedure
			precall.registerOutParameter(3, Types.VARCHAR);//Match with the correct type from stored procedure
			System.out.println("Data has been fetched successfully. ");
			precall.execute();
			System.out.println("id: "+precall.getBigDecimal(2));
			System.out.println("Name: "+precall.getString(3));
		} 
		
		
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
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
