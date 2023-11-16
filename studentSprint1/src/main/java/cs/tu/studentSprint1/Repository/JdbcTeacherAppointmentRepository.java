package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.TeacherAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JdbcTeacherAppointmentRepository implements TeacherAppointmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TeacherAppointment> findTeacherAppointmentAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM teacherAppointment",
                    BeanPropertyRowMapper.newInstance(TeacherAppointment.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
