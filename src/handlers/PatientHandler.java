package handlers;

import ResponseObjects.GenericRefResponse;
import ResponseObjects.PatientResponse;
import Utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientHandler {
    Connection con;

    public PatientHandler(Connection con){
        this.con = con;
    }

    public PatientResponse finById(String thc) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM PATIENT WHERE thc = " + thc ;
            System.out.println("Getting Generic with id: " + thc);
            ResultSet res = stmt.executeQuery(query);
            res.next();//crucial, you will get a SQ100 Error if you do not do this function call
            PatientResponse populatedRes =
                    new PatientResponse(
                            res.getString("thc"),
                            res.getString("name"),
                            res.getString("description"),
                            res.getString("description"),
                            res.getString("description"),
                            res.getString("description"),
                            res.getString("description"));
            stmt.close();
            return populatedRes;
        }
        catch (SQLException e) {
            SQLUtil.printSQLExceptions(e);
        }
        return new PatientResponse(
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR");
    }

}
