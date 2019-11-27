package ResponseObjects;

public class ChemicalRefResponse {

	public int  chemical_id;
    public String name;
    public String description;

    public ChemicalRefResponse (int chemical_id, String name, String description){
        this.chemical_id = chemical_id;
        this.name = name;
        this.description = description;
    }
}
