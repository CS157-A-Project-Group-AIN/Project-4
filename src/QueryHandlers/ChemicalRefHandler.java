package QueryHandlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import ResponseObjects.ChemicalRefResponse;
import Utils.SQLUtil;
/** Handler for queries on the Chemical Table
 * @author Irina Voronova
 * @version 1.0
 */
public class ChemicalRefHandler {
    Connection con;

    public ChemicalRefHandler(Connection con){
        this.con = con;
    }

	/**
	 * Inserts a chemical row into the chemical table
	 * @param id refers to the primary key of a chemical in the chemical table
	 * @param name refers to the column for the name of a chemical in the chemical table
	 * @param description refers to the column for description of a chemical in the chemical table
	 * @return Returns a boolean to identify whether or not the insert query Succeeded
	 * @throws ClassNotFoundException
	 */
    public boolean insertChemical(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "insert into REF_CHEMICAL values ('" + 
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


	/**
	 * Updates a chemical row in the chemical table
	 * @param id refers to the primary key of a chemical in the chemical table
	 * @param name refers to the column for the name of a chemical in the chemical table
	 * @param description refers to the column for description of a chemical in the chemical table
	 * @return Returns a boolean to identify whether or not the update query Succeeded
	 * @throws ClassNotFoundException
	 */
	public boolean updateChemical(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "UPDATE REF_CHEMICAL SET name = '"+ name + "'," + "description = " + "'" + description + "' WHERE chem_id = " + id + ";";
			System.out.println("Updating Chemical with id: " + id);
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

	/**
	 * This method gets all the names of chemicals in the chemical table
	 * @return String array with all names of chemicals in the database
	 */
	public String[] getAllChemicalNames(){
		String names[];
		try {
			ArrayList<String> chemNames = new ArrayList<String>();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_CHEMICAL;";
			System.out.println("Getting Chemicals");
			ResultSet res = stmt.executeQuery(query);
			while(res.next()) {
				chemNames.add(res.getString("name"));
			}
			stmt.close();
			return chemNames.toArray(new String[chemNames.size()]);
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}

		return new String[0];
	}

	/**
	 * This method finds a chemical in the database by its primary key
	 * @param id refers to the primary key of a chemical in the chemical table
	 * @return returns a ChemicalRefResponse object that represents the row of the chemical in the database
	 * @throws ClassNotFoundException
	 * @see   ChemicalRefResponse
	 */
	public ChemicalRefResponse finById(String id) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_CHEMICAL WHERE chem_id = " + id ;
			System.out.println("Getting Chemical with id: " + id);
			ResultSet res = stmt.executeQuery("SELECT * FROM REF_CHEMICAL WHERE chem_id = " + id );
			res.next();//crucial, you will get a SQ100 Error if you do not do this function call
			ChemicalRefResponse populatedRes = new ChemicalRefResponse(res.getInt("chem_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new ChemicalRefResponse(-1, "ERROR", "ERROR");
	}

	/**
	 * This method finds a chemical in the database with its unique name
	 * @param name refers to the column for the name of a chemical in the chemical table
	 * @return returns a ChemicalRefResponse object that represents the row of the chemical in the database
	 * @throws ClassNotFoundException
	 */
	public ChemicalRefResponse finByName(String name) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_CHEMICAL WHERE name = " + "'" + name  + "'";
			System.out.println("Getting Chemical with name: " + name);
			ResultSet res = stmt.executeQuery(query);
			res.next();//crucial, you will get an Error if you do not do this function call
			ChemicalRefResponse populatedRes = new ChemicalRefResponse(res.getInt("chem_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new ChemicalRefResponse(-1, "ERROR", "ERROR");
	}


}
