package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.StudentAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;


@Repository
public class JdbcStudentAppointmentRepository implements StudentAppointmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int saveStudentAppointment(StudentAppointment studentAppointment) {
        String studentID="6509999999";
        if(Objects.equals(studentAppointment.getType(), "request")){
            jdbcTemplate.update("INSERT INTO studentAppointment(studentID,type,reason,day1,time1,day2,time2)\n"+
                            "VALUES (?,?,?,?,?,?,?);\n",
                    new Object[]{studentID, studentAppointment.getType(),studentAppointment.getReason(),null,null,null,null});
        }
        else if(Objects.equals(studentAppointment.getType(), "other")){
            jdbcTemplate.update("INSERT INTO studentAppointment(studentID,type,reason,day1,time1,day2,time2)\n"+
                            "VALUES (?,?,?,?,?,?,?);\n",
                    new Object[]{studentID, studentAppointment.getType(),studentAppointment.getReason(),studentAppointment.getDay1(),
                            studentAppointment.getTime1(),studentAppointment.getDay2(),studentAppointment.getTime2()});
        }
        return 0;
    }
}
