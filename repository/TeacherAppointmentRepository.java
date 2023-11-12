package cs.tu.sprint1.Repository;

import cs.tu.sprint1.Model.TeacherAppointment;

import java.util.List;

public interface TeacherAppointmentRepository {
    int saveTeacherAppointment(TeacherAppointment teacherAppointment);
    List<TeacherAppointment> findTeacherAppointmentAll();

}
