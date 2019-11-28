package ResponseObjects;

/** Represents a column for a generic in the generic table.
 * @author Nathaniel Boas
 * @version 1.0
 */
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
