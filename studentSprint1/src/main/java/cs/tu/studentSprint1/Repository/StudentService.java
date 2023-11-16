package cs.tu.studentSprint1.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.tu.studentSprint1.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private Student currentStudent; // Remove @Autowired here

    // Constructor injection or setter method to set the currentStudent

    public String getStudent() {
        return currentStudent.toString();
    }

    public void setStudent(Student student){
        currentStudent = student;
    }

    public String getStudentNameTH() {
        return currentStudent.getDisplayname_th();
    }
}
