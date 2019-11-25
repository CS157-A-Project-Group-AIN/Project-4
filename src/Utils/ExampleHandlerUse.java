package src.Utils;
import src.ResponseObjects.ChemicalRefResponse;
import src.ResponseObjects.GenericRefResponse;
import src.handlers.Handler;

import java.lang.reflect.Field;


public class ExampleHandlerUse {

    public static void main (String args[]){

        final String id = "180";
        final String name = "mercury";
        final String description = "Gets you lit!";

        final Handler handlers = new Handler();

        try {
            handlers.chemicalRefHandler.insertChemical(id, name,description);//Inserting
            handlers.chemicalRefHandler.updateChemical(id,name,"Does not get you lit");//Editing
            ChemicalRefResponse res = handlers.chemicalRefHandler.finById(id);//Selecting
            /*This portion prints out the result*/
            StringBuilder resOutput = new StringBuilder();
            resOutput.append("Response : ");
            for (Field field : res.getClass().getDeclaredFields()) {
                resOutput.append(field.getName()+ " : "+ field.get(res) + " ");
            }
            System.out.println(resOutput.toString());


        } catch (ClassNotFoundException | IllegalAccessException e){
            e.printStackTrace();
        }


    }

}
