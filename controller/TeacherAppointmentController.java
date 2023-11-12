package cs.tu.sprint1.Controller;

import cs.tu.sprint1.Model.TeacherAppointment;
import cs.tu.sprint1.Repository.TeacherAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TeacherAppointmentController {
    @Autowired
    TeacherAppointmentRepository teacherAppointmentRepository;

    @PostMapping(value="/teacherAppointment",consumes = {"application/json"})
    public ResponseEntity<String> createTeacherAppointment(@RequestBody TeacherAppointment teacherAppointment){
        try{
            teacherAppointmentRepository.saveTeacherAppointment(new TeacherAppointment(teacherAppointment.getDate(),teacherAppointment.getStartTime(),
                    teacherAppointment.getEndTime(),teacherAppointment.getSelectedType(),teacherAppointment.getTextType()));
            return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
        }
        catch (Exception e){
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
