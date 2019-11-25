package handlers;

import ResponseObjects.GenericRefResponse;
import Utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChemicalRefHandler {
    Connection con;

    public ChemicalRefHandler(Connection con){
        this.con = con;
    }

    //The statement need to be redone for this class
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

    //The statement need to be redone for this class
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

    //The statement need to be redone for this class
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
}
