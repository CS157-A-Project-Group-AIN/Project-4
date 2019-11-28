package sqlhandlers;

import java.sql.Connection;
import java.sql.Statement;

public class AudiologyHandler {
    Connection con;

    public AudiologyHandler(Connection con){
        this.con = con;
    }

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
