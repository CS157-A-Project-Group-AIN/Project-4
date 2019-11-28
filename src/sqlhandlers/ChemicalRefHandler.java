package sqlhandlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import ResponseObjects.ChemicalRefResponse;
import Utils.SQLUtil;

public class ChemicalRefHandler {
    Connection con;

    public ChemicalRefHandler(Connection con){
        this.con = con;
    }
    
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
