package handlers;
import  Utils.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Handler {
    private  String USERNAME = Config.USERNAME;
    private  String PASSWORD = Config.PASSWORD;
    private  String DB_URL = Config.DB_URL;

    public  AudiologyHandler audiologyHandler;
    public  ChemicalRefHandler chemicalRefHandler;
    public  DiseaseRefHandler diseaseRefHandler;
    public  MedicamentRefHandler medicamentRefHandler;
    public  PharmocologyHandler pharmocologyHandler;
    public  GenericRefHandler genericRefHandler;
    public PatientHandler patientHandler;
    public VisitHandler visitHandler;


    public Handler() {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            this.genericRefHandler = new GenericRefHandler(con);
            this.pharmocologyHandler = new PharmocologyHandler(con);
            this.medicamentRefHandler = new MedicamentRefHandler(con);
            this.diseaseRefHandler = new DiseaseRefHandler(con);
            this.chemicalRefHandler = new ChemicalRefHandler(con);
            this.audiologyHandler = new AudiologyHandler(con);
            this.patientHandler = new PatientHandler(con);
            this.visitHandler = new VisitHandler(con);

        } catch (SQLException e){
            e.printStackTrace();
        }

    }}
