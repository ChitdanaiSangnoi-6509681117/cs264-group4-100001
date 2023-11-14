package th.ac.tu.cs.services.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudent(){
        return List.of(
                new Student(
                        "10",
                        "ปกติ",
                        "6509681083",
                        "Mr",
                        "กฤชประพัตธ์ เลิศประเสริฐภากร",
                        "krichpapath lertprasertphakorn",
                        "krichpapath.ler@dome.tu.ac.th",
                        "ภาควิชาวิทยาการคอมพิวเตอร์",
                        "คณะวิทยาศาสตร์และเทคโนโลยี"
                )
        );
    }
}
