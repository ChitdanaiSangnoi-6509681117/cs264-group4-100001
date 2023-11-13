package cs.tu.studentSprint1.Model;

public class RequestForm {

    String reason;
    String term;
    String year;
    String paidMonth;
    String paidYear;
    String type;
////////request add Withdraw


////////request retire

    public RequestForm(){}
    public RequestForm(String reason){
        setReason(reason);
        setType("other");
    }
    public RequestForm(String term,String year, String paidMonth, String paidYear){
        setTerm(term);
        setYear(year);
        setPaidMonth(paidMonth);
        setPaidYear(paidYear);
        setType("tuitionFee");
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPaidMonth() {
        return paidMonth;
    }

    public void setPaidMonth(String paidMonth) {
        this.paidMonth = paidMonth;
    }

    public String getPaidYear() {
        return paidYear;
    }

    public void setPaidYear(String paidYear) {
        this.paidYear = paidYear;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
