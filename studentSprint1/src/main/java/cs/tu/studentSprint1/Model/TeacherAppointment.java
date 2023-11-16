package cs.tu.studentSprint1.Model;

public class TeacherAppointment {
    String date;
    String startTime;
    String endTime;
    String selectedType;
    String textType;

    public TeacherAppointment(){}

    public TeacherAppointment(String date, String startTime, String endTime, String selectedType, String textType){
        setDate(date);
        setStartTime(startTime);
        setEndTime(endTime);
        setSelectedType(selectedType);
        setTextType(textType);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

}
