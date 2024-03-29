package QueryHandlers;
import java.sql.*;
import java.util.ArrayList;

import Utils.SQLUtil;
import ResponseObjects.GenericRefResponse;

/** Handler for queries on the Generic Table
 * @author Nathaniel Boas
 * @version 1.0
 */
public class GenericRefHandler {

	private Connection con;

	public GenericRefHandler(Connection con){
		this.con = con;
	}

	/**
	 * Inserts a generic row into the generic table
	 * @param id refers to the primary key of a generic in the generic table
	 * @param name refers to the column for the name of a generic in the generic table
	 * @param description refers to the column for description of a generic in the generic table
	 * @return Returns a boolean to identify whether or not the insert query Succeeded
	 * @throws ClassNotFoundException
	 */
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

	/**
	 * Updates a generic row in the generic table
	 * @param id refers to the primary key of a generic in the generic table
	 * @param name refers to the column for the name of a generic in the generic table
	 * @param description refers to the column for description of a generic in the generic table
	 * @return Returns a boolean to identify whether or not the update query Succeeded
	 * @throws ClassNotFoundException
	 */
	public boolean updateGeneric(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "UPDATE REF_GENERIC SET name = '"+ name + "'," + "description = " + "'" + description + "' WHERE generic_id = " + id + ";";
			System.out.println("Updating Generic with id: " + id);
			int status = stmt.executeUpdate(insertStmt);
			stmt.close();
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

	/**
	 * This method gets all the names of generics in the generic table
	 * @return String array with all names of generics in the database
	 */
	public String[] getAllGenericNames(){

		String names[];
		try {
			ArrayList<String> genericNames = new ArrayList<String>();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_GENERIC;";
			System.out.println("Getting Generics");
			ResultSet res = stmt.executeQuery(query);
			while(res.next()) {
				genericNames.add(res.getString("name"));
			}
			stmt.close();

			return genericNames.toArray(new String[genericNames.size()]);
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}

		return new String[0];
	}

	/**
	 * This method finds a generic in the database by its primary key
	 * @param id refers to the primary key of a generic in the generic table
	 * @return returns a GenericRefResponse object that represents the row of the generic in the database
	 * @throws ClassNotFoundException
	 * @see   GenericRefResponse
	 */
	public GenericRefResponse finById(String id) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_GENERIC WHERE generic_id = " + id ;
			System.out.println("Getting Generic with id: " + id);
			ResultSet res = stmt.executeQuery("SELECT * FROM REF_GENERIC WHERE generic_id = " + id );
			res.next();//crucial, you will get a SQ100 Error if you do not do this function call
			GenericRefResponse populatedRes = new GenericRefResponse(res.getInt("generic_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new GenericRefResponse(-1, "ERROR", "ERROR");
	}

	/**
	 * This method finds a generic in the database with its unique name
	 * @param name refers to the column for the name of a generic in the generic table
	 * @return returns a GenericRefResponse object that represents the row of the generic in the database
	 * @throws ClassNotFoundException
	 * @see   GenericRefResponse
	 */
	public GenericRefResponse finByName(String name) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			//SELECT * FROM e_trt.REF_GENERIC WHERE name = 'testname';
			String query = "SELECT * FROM REF_GENERIC WHERE name = '" + name  + "'";
			System.out.println("Getting Generic with name: " + name);
			ResultSet res = stmt.executeQuery(query);
			res.next();//crucial, you will get an Error if you do not do this function call
			GenericRefResponse populatedRes = new GenericRefResponse(res.getInt("generic_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new GenericRefResponse(-1, "ERROR", "ERROR");
	}





}
