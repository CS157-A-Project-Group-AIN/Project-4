package ResponseObjects;

public class VisitResponse {

    String visit_id;
    String thc;
    String visit_nr;
    String date;
    String comments;

    public VisitResponse(
            String visit_id,
            String thc,
            String visit_nr,
            String date,
            String comments){

        this.visit_id = visit_id;
        this.thc = thc;
        this.visit_nr = visit_nr;
        this.date = date;
        this.comments = comments;

    }
}
