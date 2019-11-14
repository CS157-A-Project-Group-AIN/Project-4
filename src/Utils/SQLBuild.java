package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLBuild {
    public static String USERNAME = Config.USERNAME;
    public static String PASSWORD = Config.PASSWORD;
    public static String DB_URL = Config.DB_URL; //e_trt
    public static String JDBC_DRIVER = Config.JDBC_DRIVER;
    static String[] Tables = {
            "create table REF_DISEASE (" +
                    "disease_id SMALLINT NOT NULL," +
                    "name VARCHAR(25)," +
                    "description VARCHAR(16000)," + //16000 used for max
                    "PRIMARY KEY (disease_id)" +
                    ");"
            ,
            "create table REF_GENERIC (" +
                    "generic_id SMALLINT NOT NULL, " +
                    "name VARCHAR(25), " +
                    "description VARCHAR(16000)," +
                    "PRIMARY KEY (generic_id)" +
                    ");"
            ,
            "create table REF_CHEMICAL (" +
                    "chem_id SMALLINT NOT NULL, " +
                    "name VARCHAR(25), " +
                    "description VARCHAR(16000)," +
                    "PRIMARY KEY (chem_id)" +
                    ");"
            ,
            "create table REF_MEDICAMENT (" +
                    "medicament_id SMALLINT NOT NULL," +
                    "name VARCHAR(25), " +
                    "description VARCHAR(16000)," +
                    "usual_dose NUMERIC(28)," +
                    "generic_id SMALLINT," +
                    "chem_id SMALLINT," +
                    "disease_id SMALLINT," +
                    "PRIMARY KEY (medicament_id)," +
                    "FOREIGN KEY (generic_id) REFERENCES REF_GENERIC (generic_id)," +
                    "FOREIGN KEY (chem_id) REFERENCES REF_CHEMICAL (chem_id)," +
                    "FOREIGN KEY (disease_id) REFERENCES REF_DISEASE (disease_id)" +
                    "" +
                    ");"
                    ,
           "create table PATIENT (" +
        		   	"thc VARCHAR(16) NOT NULL," +
                    "surname VARCHAR(25)," +
                    "first_name VARCHAR(25)," +
                    "middle_name VARCHAR(25)," +
                    "SSN VARCHAR(10)," +
                    "DOB DATE," +
                    "Insurance VARCHAR(25)," +
                    "PRIMARY KEY (thc)" +
                    ");"
                    ,
            "create table VISIT (" +
                    "visit_id INTEGER NOT NULL," +
            		"thc VARCHAR(16) NOT NULL," +
                    "visit_nr SMALLINT NOT NULL," +
                    "date DATETIME," +
                    "comments VARCHAR(16000)," +
                    "PRIMARY KEY (visit_id)," +
                    "FOREIGN KEY (thc) REFERENCES PATIENT (thc)" +
                    ");"
            ,
            "create table PHARMACOLOGY (" +
                    "medicament_id SMALLINT," +
                    "visit_id INTEGER," +
                    "dose NUMERIC(28)," +
                    "duration_mo NUMERIC(28)," +
                    "comments VARCHAR(16000)," +
                    "FOREIGN KEY (medicament_id) REFERENCES REF_MEDICAMENT (medicament_id)," +
                    "FOREIGN KEY (visit_id) REFERENCES VISIT (visit_id)" +
                    ");"
            ,
            "create table AUDIOLOGICAL (" +
                    "visit_id INTEGER," +
                    "comments VARCHAR(16000)," +
                    "R25 NUMERIC(18)," +    //NUMERIC precision reduced to 18 (which is default) from 28 to avoid row size limit
                    "R50 NUMERIC(18)," +
                    "R1 NUMERIC(18)," +
                    "R2 NUMERIC(18)," +
                    "R3 NUMERIC(18)," +
                    "R4 NUMERIC(18)," +
                    "R6 NUMERIC(18)," +
                    "R8 NUMERIC(18)," +
                    "R10 NUMERIC(18)," +
                    "R12 NUMERIC(18)," +
                    "L25 NUMERIC(18)," +
                    "L50 NUMERIC(18)," +
                    "L1 NUMERIC(18)," +
                    "L2 NUMERIC(18)," +
                    "L3 NUMERIC(18)," +
                    "L4 NUMERIC(18)," +
                    "L6 NUMERIC(18)," +
                    "L8 NUMERIC(18)," +
                    "L10 NUMERIC(18)," +
                    "L12 NUMERIC(18)," +
                    "T_PR NUMERIC(18)," +
                    "T_Rm NUMERIC(18)," +
                    "T_LR NUMERIC(18)," +
                    "Th_R NUMERIC(18)," +
                    "T_RLs NUMERIC(18)," +
                    "T_PL NUMERIC(18)," +
                    "T_Lm NUMERIC(18)," +
                    "T_LL NUMERIC(18)," +
                    "Th_L NUMERIC(18)," +
                    "T_Ls NUMERIC(18)," +
                    "WNR NUMERIC(18)," +
                    "WNL NUMERIC(18)," +
                    "MRR NUMERIC(18)," +
                    "MRL NUMERIC(18)," +
                    "MRB NUMERIC(18)," +
                    "MLR NUMERIC(18)," +
                    "MLL NUMERIC(18)," +
                    "MLB NUMERIC(18)," +
                    "MBR NUMERIC(18)," +
                    "M_BL NUMERIC(18)," +
                    "M_BB NUMERIC(18)," +
                    "R_SD NUMERIC(18)," +
                    "L_SD NUMERIC(18)," +
                    "LR50 NUMERIC(18)," +
                    "LR1 NUMERIC(18)," +
                    "LR2 NUMERIC(18)," +
                    "LR3 NUMERIC(18)," +
                    "LR4 NUMERIC(18)," +
                    "LR6 NUMERIC(18)," +
                    "LR8 NUMERIC(18)," +
                    "LR12 NUMERIC(18)," +
                    "LRTP NUMERIC(18)," +
                    "LL50 NUMERIC(18)," +
                    "LL1 NUMERIC(18)," +
                    "LL2 NUMERIC(18)," +
                    "LL3 NUMERIC(18)," +
                    "LL4 NUMERIC(18)," +
                    "LL6 NUMERIC(18)," +
                    "LL8 NUMERIC(18)," +
                    "LL12 NUMERIC(18)," +
                    "LLTP NUMERIC(18)," +
                    "FOREIGN KEY (visit_id) REFERENCES VISIT (visit_id)" +
                    ");"
    };
    static String[] drop = {
            "DROP TABLE `e_trt`.`pharmacology`;",
            "DROP TABLE `e_trt`.`audiological`;",
            "DROP TABLE `e_trt`.`visit`;",
            "DROP TABLE `e_trt`.`patient`;",
            "DROP TABLE `e_trt`.`ref_medicament`;",
            "DROP TABLE `e_trt`.`ref_disease`;",
            "DROP TABLE `e_trt`.`ref_generic`;",
            "DROP TABLE `e_trt`.`ref_chemical`;"
    };

    public static void main(String[] args) throws ClassNotFoundException {


        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName(JDBC_DRIVER);

        try {
            // Get a connection from the connection factory
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Show some database/driver metadata
            SQLUtil.printDriverInfo(con);

            // Create a Statement object so we can submit SQL statements to the driver
            Statement stmt = con.createStatement();

            // Submit the statement
            for (int i = 0; i < Tables.length; ++i) {
                System.out.print(Tables[i] + "...");
                int rowsAffected = stmt.executeUpdate(Tables[i]);
                if (rowsAffected == 0)    // DDL statements return rowcount of 0
                    System.out.println("OK");
            }
            // Close the statement
            stmt.close();

            // Close the connection
            con.close();
        } catch (SQLException e) {
            SQLUtil.printSQLExceptions(e);
        }
    }
}
