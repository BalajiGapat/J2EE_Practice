package tester;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class TestDBConnection 
{
	public static void main(String[] args) 
	{
		try 
		{
			String url = "jdbc:mysql://localhost:3306/dac22?useSSL=false&allowPublicKeyRetrieval=true";
			
			//API of java.sql.DriverManager class
			//public static Connection getConnection(String url,String userName,String pwd) throws SQLException
			try(Connection cn=DriverManager.getConnection(url, "root", "root"))
			{
				System.out.println("Connected to DB :: "+cn);//
			}// cn.close()
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
