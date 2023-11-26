package User_adding_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User_adding_data 
{
	static String name;
	static long contact;
	static int n;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		insert();
	}

	public static void insert()
	{
		System.out.println("Enter number of inputs");
		n = sc.nextInt();
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/personal_information?user=postgres&password=root");
			Statement stmt = cnt.createStatement();
			
			while(n>0)
			{
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter contact details:");
				contact = sc.nextLong();
				stmt.execute("INSERT INTO details VALUES('"+name+"', "+contact+")");
				System.out.println("Data entered");
				System.out.println("----------------------");
				n--;
			}
			System.out.println();
			System.out.println("Do you want to enter more data? 	Y/N");
			String choice = sc.next();
			
			if(choice.equals("Y")|| choice.equals("y"))
			{
				insert();
			}
			else if(choice.equalsIgnoreCase("N"))
			{
				System.out.println("Thank you");
				System.out.println("Do you want to delete any data??     1/0");
				int choice2=sc.nextInt();
				switch (choice2) 
				{
				case 1: remove();
						break;
					
				case 0: System.out.println("Thank you");
						cnt.close();
						break;

				default: System.out.println("Invalid option");
						break;
				}
			}
			else
			{
				System.out.println("Invalid choice");
				cnt.close();
			}			
		}
		
	
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	public static void remove()
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			Connection cnt2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/personal_information?user=postgres&password=root");
			Statement stmt2 = cnt2.createStatement();
			System.out.println("Enter the name to delete:");
			name = sc.next();
			stmt2.execute("DELETE FROM details WHERE name = '"+name+"'");
			System.out.println("Data deleted");
			System.out.println("Do you want to delete more records??    Y/N");
			String c = sc.next();
			if(c.equalsIgnoreCase("y"))
			{
				remove();
			}
			else
			{
				System.out.println("Thank you");
				cnt2.close();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
