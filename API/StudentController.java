package th.ac.tu.cs.services.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class StudentController {
    private final StudentService studentService;
    private final JdbcStudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, JdbcStudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudent(){
        return  studentService.getStudent();
    }

    @PostMapping("/saveStudent")
    public void save(@RequestBody Student student) {
        studentRepository.saveStudent(student);
    }

    @RequestMapping("/findStudentId")
    public List<Student> findByStudentId(@RequestParam String username) {
        return studentRepository.findByStudentId(username);
    }
    @PostMapping("/updateStudent")
    public  void  updateStudent(@RequestBody Student student, @RequestParam String username){
        studentRepository.updateStudent(student, username);
    }
    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam String username){
        studentRepository.deleteByStudentId(username);
    }

}
