package th.ac.tu.cs.services.student;

import java.util.List;

public interface StudentInterface {
    void saveStudent(Student student);
    void updateStudent(Student student, String studentId);
    void deleteByStudentId(String studentId);
    List<Student> findByStudentId(String id);
}
