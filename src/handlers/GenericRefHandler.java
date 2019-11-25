package src.handlers;
import java.sql.*;
import src.Utils.SQLUtil;
import src.ResponseObjects.GenericRefResponse;

public class GenericRefHandler {

	private Connection con;

	public GenericRefHandler(Connection con){
		this.con = con;
	}
	
	public boolean insertGeneric(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "insert into REF_GENERIC values ('" + 
					id + "','" +
					name + "','"+
					description + "')";
			System.out.println(insertStmt);
			int status = stmt.executeUpdate(insertStmt);
			stmt.close();
			//con.close();
			if(status == 1) {
				System.out.println("Status: 200");
				return true;
			}
		}
		catch (SQLException e) {
          	 	SQLUtil.printSQLExceptions(e);
		}	
		return false;
	}

	public boolean updateGeneric(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "UPDATE REF_GENERIC SET name = '"+ name + "'," + "description = " + "'" + description + "' WHERE generic_id = " + id + ";";
			System.out.println("Updating Generic with id: " + id);
			int status = stmt.executeUpdate(insertStmt);
			stmt.close();
			//con.close();
			if(status == 1) {
				System.out.println("Status: 200");
				return true;
			}
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return false;
	}

	public GenericRefResponse finById(String id) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_GENERIC WHERE generic_id = " + id ;
			System.out.println("Getting Generic with id: " + id);
			ResultSet res = stmt.executeQuery("SELECT * FROM REF_GENERIC WHERE generic_id = " + id );
			res.next();//crucial, you will get a SQ100 Error if you do not do this function call
			GenericRefResponse populatedRes = new GenericRefResponse(res.getInt("generic_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new GenericRefResponse(-1, "ERROR", "ERROR");
	}

	public GenericRefResponse finByName(String name) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_GENERIC WHERE name = " + "'" + name  + "'";
			System.out.println("Getting Generic with name: " + name);
			ResultSet res = stmt.executeQuery(query);
			res.next();//crucial, you will get an Error if you do not do this function call
			GenericRefResponse populatedRes = new GenericRefResponse(res.getInt("generic_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new GenericRefResponse(-1, "ERROR", "ERROR");
	}




		
}
