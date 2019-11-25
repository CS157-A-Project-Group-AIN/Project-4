package ResponseObjects;

public class ChemicalRefResponse {
    public int  chem_id;
    public String name;
    public String description;

    public ChemicalRefResponse (int generic_id, String name, String description){
        this.chem_id = generic_id;
        this.name = name;
        this.description = description;
    }
}
