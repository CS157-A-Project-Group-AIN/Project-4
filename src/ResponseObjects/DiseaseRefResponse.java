package ResponseObjects;

/** Represents a column for a disease in the disease table.
 * @author Irina
 * @version 1.0
 */
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
