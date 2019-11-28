package QueryHandlers;

import ResponseObjects.GenericRefResponse;
import ResponseObjects.MedicamentRefResponse;
import Utils.SQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentRefHandler {

    private Connection con;

    public MedicamentRefHandler(Connection con){
        this.con = con;
    }

    /**
     * Inserts a medicament row into the medicament table
     * @param id refers to the primary key in the medicament table of a medicament
     * @param name refers to the column in the medicament table for the name of a medicament
     * @param description refers to the column in the medicament table for description of a medicament
     * @param dose refers to the column in the medicament table for a dosage of a medicament
     * @param genID refers to the column in the medicament table that references a generic entity
     * @param chmID refers to the column in the medicament table that references a chemical entity
     * @param disID refers to the column in the medicament table that references a disease entity
     * @return Returns a boolean to identify whether or not the insert query Succeeded
     * @throws ClassNotFoundException
     */
    public boolean insertMedicament(String id, String name, String description, String dose, String genID, String chmID, String disID) throws ClassNotFoundException {
        try {
            Statement stmt = con.createStatement();
            String insertStmt = "insert into REF_MEDICAMENT values ('" +
                    id + "','" +
                    name + "','"+
                    description + "',"+
                    dose + ", "+
                    genID + ", "+
                    chmID + ", "+
                    disID +
                    ")";
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
    /**
     * This method finds a medicament in the database by its primary key
     * @param id refers to the primary key of a medicament in the medicament table
     * @return returns a GenericRefResponse object that represents the row of the medicament in the database
     * @throws ClassNotFoundException
     * @see   MedicamentRefResponse
     */
    public MedicamentRefResponse finById(String id) throws ClassNotFoundException {
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM REF_MEDICAMENT WHERE medicament_id = " + id ;
            System.out.println("Getting Medicament with id: " + id);
            ResultSet res = stmt.executeQuery(query);
            res.next();//crucial, you will get a SQ100 Error if you do not do this function call
            MedicamentRefResponse populatedRes = new MedicamentRefResponse(res.getInt("medicament_id"), res.getString("name"), res.getString("description"),
                    res.getFloat("usual_dose"), res.getInt("generic_id"), res.getInt("chem_id"), res.getInt("disease_id"));
            stmt.close();
            return populatedRes;
        }
        catch (SQLException e) {
            SQLUtil.printSQLExceptions(e);
        }
        return new MedicamentRefResponse(-1, "ERROR", "ERROR", -1, -1, -1, -1);
    }

    /**
     * This method finds a medicament in the database with its unique name
     * @param name refers to the column for the name of a medicament in the medicament table
     * @return returns a GenericRefResponse object that represents the row of the medicament in the database
     * @throws ClassNotFoundException
     * @see   MedicamentRefResponse
     */
    public MedicamentRefResponse finByName(String name) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM REF_MEDICAMENT WHERE name = '" + name  + "'";
            System.out.println("Getting Medicament with name: " + name);
            ResultSet res = stmt.executeQuery(query);
            res.next();//crucial, you will get an Error if you do not do this function call
            MedicamentRefResponse populatedRes = new MedicamentRefResponse(res.getInt("medicament_id"), res.getString("name"), res.getString("description"),
                    res.getFloat("usual_dose"), res.getInt("generic_id"), res.getInt("chem_id"), res.getInt("disease_id"));
            stmt.close();
            return populatedRes;
        }
        catch (SQLException e) {
            SQLUtil.printSQLExceptions(e);
        }
        return new MedicamentRefResponse(-1, "ERROR", "ERROR", -1, -1, -1, -1);
    }

    /**
     * Updates a medicament row in the medicament table
     * @param id refers to the primary key in the medicament table of a medicament
     * @param name refers to the column in the medicament table for the name of a medicament
     * @param description refers to the column in the medicament table for description of a medicament
     * @param dose refers to the column in the medicament table for a dosage of a medicament
     * @param genID refers to the column in the medicament table that references a generic entity
     * @param chmID refers to the column in the medicament table that references a chemical entity
     * @param disID refers to the column in the medicament table that references a disease entity
     * @return Returns a boolean to identify whether or not the update query Succeeded
     * @throws ClassNotFoundException
     */
    public boolean updateMedicament(String id, String name, String description, String dose, String genID, String chmID, String disID) throws ClassNotFoundException {

        try {
            Statement stmt = con.createStatement();
            String insertStmt = "UPDATE REF_MEDICAMENT SET name = '"+ name + "', " + "description = " + "'" + description + "', " +
                    "usual_dose = " + dose + ", " + "generic_id = " + genID + ", " + "chem_id = " + chmID + ", " + "disease_id = " + disID + " WHERE medicament_id = " + id + ";";
            System.out.println("Updating medicament with id: " + id);
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
}
