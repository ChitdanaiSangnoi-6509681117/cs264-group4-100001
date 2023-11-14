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
            if(Objects.equals(requestForm.getType(), "tuitionFee")){
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getTerm(),requestForm.getYear()
                        ,requestForm.getPaidMonth(),requestForm.getPaidYear(),requestForm.getFile(),requestForm.getType()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }
            else if(Objects.equals(requestForm.getType(),"other")){
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getReason(),requestForm.getFile(),requestForm.getType()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }
            else if(Objects.equals(requestForm.getType(),"withdrawal")){
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getTerm(),requestForm.getCourse(),requestForm.getCourseNumber()
                        ,requestForm.getSection(),requestForm.getAdd_withdraw(),requestForm.getReason(),requestForm.getYear(),requestForm.getFile(),requestForm.getType()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }
            else{
                requestFormRepository.saveRequestForm(new RequestForm(requestForm.getTerm(),requestForm.getYear(),requestForm.getReason(),requestForm.getDebtOption()
                        ,requestForm.getDept(),requestForm.getAmount(),requestForm.getGradeOption(),requestForm.getFile()));
                return new ResponseEntity<String>("student was created successfully.", HttpStatus.CREATED);
            }

        }
        catch (Exception e){
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
