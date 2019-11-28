package Utils;
import  ResponseObjects.GenericRefResponse;
import QueryHandlers.Handlers;

import java.lang.reflect.Field;


public class ExampleHandlerUse {

    public static void main (String args[]){

        final String id = "13";
        final String name = "Drug13";
        final String description = "This is drug 13";

        final Handlers handlers = new Handlers();

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

        for (String s: handlers.genericRefHandler.getAllGenericNames()) {
            System.out.println(s);
        }


    }

}
