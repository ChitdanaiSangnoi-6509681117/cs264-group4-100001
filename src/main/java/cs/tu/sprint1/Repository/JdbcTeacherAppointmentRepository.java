package cs.tu.sprint1.Repository;

import cs.tu.sprint1.Model.TeacherAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTeacherAppointmentRepository implements TeacherAppointmentRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveTeacherAppointment(TeacherAppointment teacherAppointment){
        jdbcTemplate.update("INSERT INTO teacherAppointment(date,startTime,endTime,selectedType,textType)\n"+
                "VALUES (?,?,?,?,?);\n",
                new Object[]{teacherAppointment.getDate(), teacherAppointment.getStartTime(),
                teacherAppointment.getEndTime(), teacherAppointment.getSelectedType(), teacherAppointment.getTextType()});
        return 0;
    }
    @Override
    public List<TeacherAppointment> findTeacherAppointmentAll() {
        return jdbcTemplate.query("SELECT * from teacherAppointment", BeanPropertyRowMapper.newInstance(TeacherAppointment.class));
    }

}
