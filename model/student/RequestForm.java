package cs.tu.studentSprint1.Model;

import org.springframework.data.relational.core.mapping.Table;

@Table(name = "RequestForm")
public class RequestForm {

    private String reason;
    private String term;
    private String year;
    private String paidMonth;
    private String paidYear;
    private String type;
    private String debtOption;
    private String dept;
    private String amount;
    private String gradeOption;
    private String course;
    private String courseNumber;
    private String section;
    private String add_withdraw;
    private FileInfo[] file = new FileInfo[5];


    public RequestForm(){}
    public RequestForm(String reason,FileInfo[] file, String type){
        setReason(reason);
        setFile(file);
        setType(type);
    }
    //tuitionFee
    public RequestForm(String term,String year, String paidMonth, String paidYear,FileInfo[] file, String type){
        setTerm(term);
        setYear(year);
        setPaidMonth(paidMonth);
        setPaidYear(paidYear);
        setFile(file);
        setType(type);
    }
    //resignation
    public RequestForm(String  term, String year, String reason, String debtOption, String dept, String amount, String gradeOption, FileInfo[] file){
        setTerm(term);
        setYear(year);
        setReason(reason);
        setDebtOption(debtOption);
        setDept(dept);
        setAmount(amount);
        setGradeOption(gradeOption);
        setType("resignation");
        setFile(file);
    }

    public RequestForm(String term, String course, String courseNumber, String section,
                       String add_withdraw, String reason, String year, FileInfo[] file, String type){
        setTerm(term);
        setYear(year);
        setReason(reason);
        setCourse(course);
        setCourseNumber(courseNumber);
        setSection(section);
        setAdd_withdraw(add_withdraw);
        setType(type);
        setFile(file);
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

    public String getDebtOption() {
        return debtOption;
    }

    public void setDebtOption(String debtOption) {
        this.debtOption = debtOption;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGradeOption() {
        return gradeOption;
    }

    public void setGradeOption(String gradeOption) {
        this.gradeOption = gradeOption;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAdd_withdraw() {
        return add_withdraw;
    }

    public void setAdd_withdraw(String add_withdraw) {
        this.add_withdraw = add_withdraw;
    }
}
