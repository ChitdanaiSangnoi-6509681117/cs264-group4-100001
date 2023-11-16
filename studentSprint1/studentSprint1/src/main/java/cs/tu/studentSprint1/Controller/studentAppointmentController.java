package cs.tu.studentSprint1.Controller;

import cs.tu.studentSprint1.Model.StudentAppointment;
import cs.tu.studentSprint1.Repository.StudentAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class studentAppointmentController {
    @Autowired
    StudentAppointmentRepository studentAppointmentRepository;

    @PostMapping(value="/studentAppointment",consumes = {"application/json"})
    public ResponseEntity<String> createStudentAppointment(@RequestBody StudentAppointment studentAppointment){
        try{
            if(Objects.equals(studentAppointment.getType(), "other")){
                studentAppointmentRepository.saveStudentAppointment(new StudentAppointment(studentAppointment.getType(),studentAppointment.getReason(),studentAppointment.getDay1(),
                        studentAppointment.getTime1(),studentAppointment.getDay2(),studentAppointment.getTime2()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }
            else if(Objects.equals(studentAppointment.getType(), "request")){
                studentAppointmentRepository.saveStudentAppointment(new StudentAppointment(studentAppointment.getType(),studentAppointment.getReason()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }

        }
        catch (Exception e){
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

}
