package th.ac.tu.cs.services.student;

public class Student {
    private String statusid;
    private String statusname;
    private String userName;
    private String displayname_th;
    private String displayname_en;
    private String email;
    private String department;
    private String faculty;

    public Student() {
    }

    public Student(String userName) {
        this.userName = userName;
    }

    public Student(String statusid,
                   String statusname,
                   String userName,
                   String prefixname,
                   String displayname_th,
                   String displayname_en,
                   String email,
                   String department,
                   String faculty) {
        this.statusid = statusid;
        this.statusname = statusname;
        this.userName = userName;
        this.displayname_th = displayname_th;
        this.displayname_en = displayname_en;
        this.email = email;
        this.department = department;
        this.faculty = faculty;
    }

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayname_th() {
        return displayname_th;
    }

    public void setDisplayname_th(String displayname_th) {
        this.displayname_th = displayname_th;
    }

    public String getDisplayname_en() {
        return displayname_en;
    }

    public void setDisplayname_en(String displayname_en) {
        this.displayname_en = displayname_en;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "statusid='" + statusid + '\'' +
                ", statusname='" + statusname + '\'' +
                ", userName='" + userName + '\'' +
                ", displayname_th='" + displayname_th + '\'' +
                ", displayname_en='" + displayname_en + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
