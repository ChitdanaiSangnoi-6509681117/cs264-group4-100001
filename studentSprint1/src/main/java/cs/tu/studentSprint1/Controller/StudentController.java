package cs.tu.studentSprint1.Controller;

import cs.tu.studentSprint1.Model.Student;
import cs.tu.studentSprint1.Repository.JdbcStudentRepository;
import cs.tu.studentSprint1.Repository.StudentService;
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
    public String getStudent(){
        return  studentService.getStudent();
    }

    @GetMapping("/getStudentNameTH")
    public String getStudentNameTH() {
        return studentService.getStudentNameTH();
    }

    @PostMapping("/saveStudent")
    public void save(@RequestBody Student student) {
        studentRepository.saveStudent(student);
        studentService.setStudent(student);
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