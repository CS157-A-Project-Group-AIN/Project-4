package handlers;


import ResponseObjects.VisitResponse;
import Utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitHandler {

    Connection con;

    public VisitHandler(Connection con){
        this.con = con;
    }

    public VisitResponse finById(String visit_id) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Visit WHERE visit_id = " + visit_id ;
            System.out.println("Getting Generic with id: " + visit_id);
            ResultSet res = stmt.executeQuery(query);
            res.next();//crucial, you will get a SQ100 Error if you do not do this function call
            VisitResponse populatedRes =
                    new VisitResponse(
                            res.getString("visit_id"),
                            res.getString("thc"),
                            res.getString("visit_nr"),
                            res.getString("date"),
                            res.getString("comments"));

            stmt.close();
            return populatedRes;
        }
        catch (SQLException e) {
            SQLUtil.printSQLExceptions(e);
        }
        return new VisitResponse(
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR",
                "ERROR");

    }

}
