package sqlhandlers;


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

    public boolean updateVisit(
            String visit_id,
            String thc,
            String visit_nr,
            String date,
            String comments) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String insertStmt = "UPDATE Visit SET" +
                    "thc = '"+ thc + "'," +
                    "visit_nr = " + "'" + visit_nr + "'" +
                    "date = " + "'" + date + "'" +
                    "comments = " + "'" + comments + "'" +
                    "WHERE visit_id = " + visit_id + ";";
            System.out.println("Updating Visit with visit_id: " + visit_id);
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

    public boolean visit(
            String visit_id,
            String thc,
            String visit_nr,
            String date,
            String comments) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String insertStmt = "insert into REF_CHEMICAL values ('" +
                    generateId() + "','" +
                    thc + "','"+
                    visit_nr + "','"+
                    date + "','"+
                    comments + "')";
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

    private int generateId(){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from VISIT");
            rs.next();
            return rs.getInt(1);
        } catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }

}
