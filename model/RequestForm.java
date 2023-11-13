package cs.tu.studentSprint1.Model;

public class RequestForm {

    private String reason;
    private String term;
    private String year;
    private String paidMonth;
    private String paidYear;
    private String type;
    private FileInfo[] file = new FileInfo[5];


////////request add Withdraw


////////request retire

    public RequestForm(){}
    public RequestForm(String reason,FileInfo[] file){
        setReason(reason);
        setFile(file);
        setType("other");
    }
    public RequestForm(String term,String year, String paidMonth, String paidYear,FileInfo[] file){
        setTerm(term);
        setYear(year);
        setPaidMonth(paidMonth);
        setPaidYear(paidYear);
        setFile(file);
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
    public FileInfo[] getFile() {
        return file;
    }

    public void setFile(FileInfo[] file) {
        this.file = file;
    }
}
