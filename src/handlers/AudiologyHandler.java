package handlers;

import java.sql.Connection;

public class AudiologyHandler {
    Connection con;

    public AudiologyHandler(Connection con){
        this.con = con;
    }

    public boolean insertAudioLogy(String visit_id, String comments, String[] readings){

        StringBuilder queryBuilder = new StringBuilder();
        String query = "";

        try{
            queryBuilder.append( "insert into AUDIOLOGICAL values ('");
            queryBuilder.append(" "+ visit_id +",");
            queryBuilder.append(" "+ comments +",");
            for (int i = 0; i < readings.length-1 ; i++) {
                queryBuilder.append(" "+ readings[i] +",");
            }
            queryBuilder.append(" "+ readings[readings.length] +");");
        }catch(Exception e){
            e.printStackTrace();
        }

    return false;
    }
    
}
