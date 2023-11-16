package cs.tu.studentSprint1.Model;

public class StudentAppointment {
    private String reason;
    private String day1;
    private String time1;
    private String day2;
    private String time2;
    private String type;

    public StudentAppointment(){
    }

    public StudentAppointment(String type,String reason){
        setType(type);
        setReason(reason);
    }
    public StudentAppointment(String type,String reason,String day1,String time1,String day2,String time2){
        setType(type);
        setReason(reason);
        setDay1(day1);
        setTime1(time1);
        setDay2(day2);
        setTime2(time2);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
