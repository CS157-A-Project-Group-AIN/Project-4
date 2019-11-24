package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static Utils.Config.*;

class Patient {
    public static String THC = "1236";
    public static String SUR_NAME = "Dean";
    public static String FIRST_NAME = "Karl";
    public static String MIDDLE_NAME = "Bob";
    public static String SSN = "123456129";
    public static String DOB = "1994-11-29";
    public static String INSURANCE = "Medicade";
}

public class Seed {

    public static void main(String args[]){
        addPatient();
    }

    private static void addPatient(){
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
            Statement stmt = con.createStatement();

            String insertStmt = "insert into PATIENT values ('" +
                    Patient.THC + "','" +
                    Patient.SUR_NAME +  "','" +
                    Patient.FIRST_NAME + "','" +
                    Patient.MIDDLE_NAME + "','" +
                    Patient.SSN + "','" +
                    Patient.DOB + "','" +
                    Patient.INSURANCE+
                    "');";

            System.out.println("Inserting");
            System.out.println("Patient: { "+
                    Patient.THC + ", " +
                    Patient.SUR_NAME +  ", " +
                    Patient.FIRST_NAME + ", " +
                    Patient.MIDDLE_NAME + ", " +
                    Patient.SSN + ", " +
                    Patient.DOB + ", " +
                    Patient.INSURANCE + " }"
            );

            int status = stmt.executeUpdate(insertStmt);
            stmt.close();
            con.close();
            if(status == 1) {
                System.out.println("Satus: 200");
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }}
