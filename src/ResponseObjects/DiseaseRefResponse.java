package src.ResponseObjects;

public class DiseaseRefResponse {
	public int  disease_id;
    public String name;
    public String description;

    public DiseaseRefResponse (int disease_id, String name, String description){
        this.disease_id = disease_id;
        this.name = name;
        this.description = description;
    }
}
