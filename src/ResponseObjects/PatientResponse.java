package ResponseObjects;

public class PatientResponse {

    String thc;
    String sur_name;
    String first_name;
    String middle_name;
    String ssn;
    String DOB;
    String insurance;

    public PatientResponse(
            String thc,
            String sur_name,
            String first_name,
            String middle_name,
            String ssn,
            String DOB,
            String insurance
    ){
        this.thc = thc;
        this.sur_name = sur_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.ssn = ssn;
        this.DOB = DOB;
        this.insurance = insurance;
    }
}