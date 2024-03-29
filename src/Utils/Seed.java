package Utils;

import QueryHandlers.Handlers;

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

    private static Handlers handlers;

    public static void main(String args[]) {
        handlers = new Handlers();
        addPatient();
        addVisit();
        addChemicals();
        addDiseases();
        addGenerics();

    }

    private static void addPatient() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();


            String insertStmt = "insert into PATIENT values ('" +
                    Patient.THC + "','" +
                    Patient.SUR_NAME + "','" +
                    Patient.FIRST_NAME + "','" +
                    Patient.MIDDLE_NAME + "','" +
                    Patient.SSN + "','" +
                    Patient.DOB + "','" +
                    Patient.INSURANCE +
                    "');";

            System.out.println("Inserting");
            System.out.println("Patient: { " +
                    Patient.THC + ", " +
                    Patient.SUR_NAME + ", " +
                    Patient.FIRST_NAME + ", " +
                    Patient.MIDDLE_NAME + ", " +
                    Patient.SSN + ", " +
                    Patient.DOB + ", " +
                    Patient.INSURANCE + " }"
            );

            int status = stmt.executeUpdate(insertStmt);
            stmt.close();
            con.close();
            if (status == 1) {
                System.out.println("Satus: 200");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void addVisit() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = con.createStatement();


            String insertStmt = "insert into Visit values (" +
                    1 + ",'" +
                    Patient.THC + "'," +
                    1 + ",'" +
                    "2019-11-27" + "'," +
                    "'This is comments'"+
                    ");";

            System.out.println(insertStmt);

            int status = stmt.executeUpdate(insertStmt);
            stmt.close();
            con.close();
            if (status == 1) {
                System.out.println("Satus: 200");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void addGenerics() {


        for(int i =1; i <=12; i++) {
            try {
                handlers.genericRefHandler.insertGeneric(Integer.toString(i), "Drug" + i, "this is drug" + i);
                System.out.println("Inserted  into ref_generic( " + i + ", Drug"+ i + ", this is drug" + i + ")");
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    private static void addChemicals() {


        for(int i =1; i <=12; i++) {
            try {
                handlers.chemicalRefHandler.insertChemical(Integer.toString(i), "Chemical" + i, "this is chemical" + i);
                System.out.println("Inserted  into ref_chemical( " + i + ", Chemical"+ i + ", this is chemical" + i + ")");
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    private static void addDiseases() {


        for(int i =1; i <=12; i++) {
            try {
                handlers.diseaseRefHandler.insertDisease(Integer.toString(i), "disease" + i, "this is disease" + i);
                System.out.println("Inserted  into ref_disease ( " + Integer.toString(i) + ", disease"+ i + ", this is disease" + i + ")" );
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
