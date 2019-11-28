package QueryHandlers;

import ResponseObjects.PatientResponse;
import Utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Handler for queries on the Patient Table
 * @author Nathaniel Boas
 * @version 1.0
 */
public class PatientHandler {
    Connection con;

    public PatientHandler(Connection con){
        this.con = con;
    }

    /**
     * Method uses mysql query to find a patient in the database by using a thc number.
     * @param thc this is the unique key for a patient in the database
     * @return
     * @throws ClassNotFoundException
     * @see PatientResponse
     */
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

    /**
     * Method finds the first patient in the database and returns it
     * @return Returns an instance of Patient Response Object
     * @see PatientResponse
     */
    public PatientResponse firstPatientEntry(){
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM PATIENT" ;
            System.out.println("Getting Patient");
            ResultSet res = stmt.executeQuery(query);
            res.next();//crucial, you will get a SQ100 Error if you do not do this function call
            PatientResponse populatedRes =
                    new PatientResponse(
                            res.getString("thc"),
                            res.getString("surname"),
                            res.getString("first_name"),
                            res.getString("middle_name"),
                            res.getString("SSN"),
                            res.getString("DOB"),
                            res.getString("Insurance"));
            stmt.close();
            return populatedRes;
        }
        catch (SQLException e) {
            System.out.println("Status: 200 OK");
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
