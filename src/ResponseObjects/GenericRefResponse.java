package ResponseObjects;

public class GenericRefResponse {
    public int  generic_id;
    public String name;
    public String description;

    public GenericRefResponse (int generic_id, String name, String description){
        this.generic_id = generic_id;
        this.name = name;
        this.description = description;
    }
}
