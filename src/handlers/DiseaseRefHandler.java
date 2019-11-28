package handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ResponseObjects.DiseaseRefResponse;
import Utils.SQLUtil;

public class DiseaseRefHandler {
    Connection con;

    public DiseaseRefHandler(Connection con){
        this.con = con;
    }

    public boolean insertDisease(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "insert into REF_DISEASE values ('" + 
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

	public boolean updateDisease(String id, String name, String description) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String insertStmt = "UPDATE REF_DISEASE SET name = '"+ name + "'," + "description = " + "'" + description + "' WHERE disease_id = " + id + ";";
			System.out.println("Updating Disease with id: " + id);
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


	public String[] getAllDiseaseNames(){
		String names[];
		try {
			ArrayList<String> disNames = new ArrayList<String>();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_DISEASE;";
			System.out.println("Getting Diseases");
			ResultSet res = stmt.executeQuery(query);
			while(res.next()) {
				disNames.add(res.getString("name"));
			}
			stmt.close();
			return disNames.toArray(new String[disNames.size()]);
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}

		return new String[0];
	}

	public DiseaseRefResponse finById(String id) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_DIESEASE WHERE disease_id = " + id ;
			System.out.println("Getting Disease with id: " + id);
			ResultSet res = stmt.executeQuery("SELECT * FROM REF_DISEASE WHERE disease_id = " + id );
			res.next();//crucial, you will get a SQ100 Error if you do not do this function call
			DiseaseRefResponse populatedRes = new DiseaseRefResponse(res.getInt("disease_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new DiseaseRefResponse(-1, "ERROR", "ERROR");
	}

	public DiseaseRefResponse finByName(String name) throws ClassNotFoundException {

		try {
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM REF_DISEASE WHERE name = " + "'" + name  + "'";
			System.out.println("Getting Disease with name: " + name);
			ResultSet res = stmt.executeQuery(query);
			res.next();//crucial, you will get an Error if you do not do this function call
			DiseaseRefResponse populatedRes = new DiseaseRefResponse(res.getInt("disease_id"), res.getString("name"), res.getString("description"));
			stmt.close();
			//con.close();
			return populatedRes;
		}
		catch (SQLException e) {
			SQLUtil.printSQLExceptions(e);
		}
		return new DiseaseRefResponse(-1, "ERROR", "ERROR");
	}
}
