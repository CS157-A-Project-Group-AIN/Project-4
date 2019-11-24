package handlers;

import java.sql.Connection;

public class ChemicalRefHandler {
    Connection con;

    public ChemicalRefHandler(Connection con){
        this.con = con;
    }
}
