package connector;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insertion {
	public static void main(String args[]) {
		String url = "jdbc:postgresql://localhost:5432/my_first_jdbc_project";
		String user = "postgres";
		String password = "root";

		try {
			// Step 1: Load or register driver
			Class.forName("org.postgresql.Driver");
			// Step 2: Establish COnnection
			Connection connection = DriverManager.getConnection(url, user, password);
			// Step 3: Creation of Statement
			Statement statement = connection.createStatement();
			// Step 4: Execution of statement
			statement.execute("INSERT INTO student VALUES(4,'abc')");
			// Step 5: CLose connection
			connection.close();
			System.out.println("Data inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
