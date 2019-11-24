package handlers;

import java.sql.Connection;

public class DiseaseRefHandler {
    Connection con;

    public DiseaseRefHandler(Connection con){
        this.con = con;
    }
}
