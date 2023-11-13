package cs.tu.studentSprint1.Controller;

import cs.tu.studentSprint1.Model.RequestForm;
import cs.tu.studentSprint1.Repository.RequestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class requestFormController{
    @Autowired
    RequestFormRepository requestFormRepository;
    @PostMapping(value="/requestForm",consumes = {"application/json"})
    public ResponseEntity<String> createTeacherAppointment(@RequestBody RequestForm requestForm){
        try{
            if(Objects.equals(requestForm.getYear(), "2566")){
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getTerm(),requestForm.getYear()
                        ,requestForm.getPaidMonth(),requestForm.getPaidYear(),requestForm.getFile()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }
            else if(!Objects.equals(requestForm.getReason(),"")){
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getReason(),requestForm.getFile()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }

        }
        catch (Exception e){
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
