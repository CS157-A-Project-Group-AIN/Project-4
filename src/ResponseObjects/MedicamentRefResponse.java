package ResponseObjects;

public class MedicamentRefResponse {
    public int medicament_id;
    public String name;
    public String description;
    public float usual_dose;
    public int generic_id;
    public int chem_id;
    public int disease_id;

    public MedicamentRefResponse (int medicament_id, String name, String description, float usual_dose, int generic_id, int chem_id, int disease_id){
        this.medicament_id = medicament_id;
        this.name = name;
        this.description = description;
        this.usual_dose = usual_dose;
        this.generic_id = generic_id;
        this.chem_id = chem_id;
        this. disease_id = disease_id;
    }

}
