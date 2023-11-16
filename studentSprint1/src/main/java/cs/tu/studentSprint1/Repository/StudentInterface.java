package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.Student;

import java.util.List;

public interface StudentInterface {
    void saveStudent(Student student);
    void updateStudent(Student student, String studentId);
    void deleteByStudentId(String studentId);
    List<Student> findByStudentId(String id);
    List<Student> findApproveAll();
}
