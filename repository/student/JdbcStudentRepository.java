package cs.tu.studentSprint1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import cs.tu.studentSprint1.Model.Student;


import java.util.List;

@Repository
public class JdbcStudentRepository implements StudentInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveStudent(Student student) {
        String sql = "INSERT INTO Student " +
                "(userName, statusid, statusname, displayname_th, displayname_en, email, department, faculty) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                student.getUserName(),
                student.getStatusid(),
                student.getStatusname(),
                //student.getPrefixname(),
                student.getDisplayname_th(),
                student.getDisplayname_en(),
                student.getEmail(),
                student.getDepartment(),
                student.getFaculty()
        );
    }

    public List<Student> findByStudentId(String username) {
        try {
            String sqlStudent = "SELECT * FROM Student where username = ?";
            List<Student> students = jdbcTemplate.query(sqlStudent, new BeanPropertyRowMapper<>(Student.class), username);
            System.out.println(students);
            return students;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    public void updateStudent(Student student, String username) {
        String sql = "UPDATE Student " +
                "SET statusid = ?, statusname = ?, displayname_th = ?, displayname_en = ?, email = ?, department = ?, faculty = ? " +
                "WHERE userName = ?";

        jdbcTemplate.update(sql,
                student.getStatusid(),
                student.getStatusname(),
                //student.getPrefixname(),
                student.getDisplayname_th(),
                student.getDisplayname_en(),
                student.getEmail(),
                student.getDepartment(),
                student.getFaculty(),
                username
        );
    }

    public void deleteByStudentId(String username) {
        String sql = "DELETE FROM Student WHERE userName = ?";

        jdbcTemplate.update(sql, username);
    }
}
