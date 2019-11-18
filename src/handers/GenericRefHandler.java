package handers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Config;
import Utils.SQLUtil;

public class GenericRefHandler {
	public static String USERNAME = Config.USERNAME;
    public static String PASSWORD = Config.PASSWORD;
	public static String DB_URL = Config.DB_URL;
	public static String JDBC_DRIVER = Config.JDBC_DRIVER;
	
	public static boolean insert(String id, String name, String description) throws ClassNotFoundException
	{
		Class.forName(JDBC_DRIVER);
		try
		{
		    // Get a connection from the connection factory
			Connection con = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
			// Create a Statement object so we can submit SQL statements to the driver
			Statement stmt = con.createStatement();
			// Submit the statement
			//insert into STATE values ('AK','Alaska',null,'Juneau','West', 589757, null, null)
			String insertStmt = "insert into REF_GENERIC values ('" + 
					id + "','" +
					name + "','"+
					description + "')";
			System.out.print(insertStmt);
			int status = stmt.executeUpdate(insertStmt);
			// Close the statement
			stmt.close();
			// Close the connection
			con.close();
			if(status == 1)
			{
				System.out.println(" ...OK");
				return true;
			}
		}
		catch (SQLException e)
		{
          	 	SQLUtil.printSQLExceptions(e);		
          	 
		}	
		return false;
	}

		
}
