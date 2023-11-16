package cs.tu.studentSprint1.Repository;

import cs.tu.studentSprint1.Model.TeacherAppointment;

import java.util.List;


public interface TeacherAppointmentRepository {
    List<TeacherAppointment> findTeacherAppointmentAll();

}
