package ResponseObjects;

public class DiseasRefResponse {
    public int  diseas_id;
    public String name;
    public String description;

    public DiseasRefResponse (int generic_id, String name, String description){
        this.diseas_id= generic_id;
        this.name = name;
        this.description = description;
    }
}
