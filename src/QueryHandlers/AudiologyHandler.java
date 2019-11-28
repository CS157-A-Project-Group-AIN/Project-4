package QueryHandlers;

import java.sql.Connection;
import java.sql.Statement;

/** Handler for queries on the Audiology Table
 * @author Nathaniel Boas
 * @version 1.0
 */
public class AudiologyHandler {
    Connection con;

    public AudiologyHandler(Connection con){
        this.con = con;
    }

    /**
     * This method inserts a Audiology Entity into the database.
     * @param visit_id This represents the column for a foreing key id to reference a visit entity
     * @param comments This refers to the column for comments in the Audiology table
     * @param readings This is an array that contains all the values recorded in the audiology report and the values get mapped to to each of there respective columns in the visit table
     * @return Returns a boolean to idtentify whether or not the insert query Succeeded
     */
    public boolean insertAudioLogy(String visit_id, String comments, String[] readings){

        StringBuilder queryBuilder = new StringBuilder();
        try{
            Statement stmt = con.createStatement();
            queryBuilder.append( "insert into AUDIOLOGICAL values (");
            queryBuilder.append(" "+ visit_id +",");
            queryBuilder.append(" '"+ comments +"',");
            System.out.println(readings.length);
            for (int i = 0; i < readings.length-1 ; i++) {
                queryBuilder.append(" "+ readings[i] +",");
            }
            queryBuilder.append(" "+ readings[readings.length-1] +");");
            System.out.println(queryBuilder.toString());
            stmt.execute(queryBuilder.toString());



        }catch(Exception e){
            e.printStackTrace();
        }

    return false;
    }
    
}
