package src.Utils;
import src.ResponseObjects.GenericRefResponse;
import src.handlers.Handler;//Import handlers here

import java.lang.reflect.Field;


public class ExampleHandlerUse {

    public static void main (String args[]){

        final String id = "111";
        final String name = "Drug183";
        final String description = "Gets you lit!";

        final Handler handlers = new Handler();

        try {
            handlers.genericRefHandler.insertGeneric(id, name,description);//Inserting
            handlers.genericRefHandler.updateGeneric(id,name,"Does not get you lit");//Editing
            GenericRefResponse res = handlers.genericRefHandler.finById(id);//Selecting
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
