package src.handlers;

import java.sql.Connection;

public class PharmocologyHandler {

    Connection con;

    public PharmocologyHandler(Connection con){
        this.con = con;
    }
}
