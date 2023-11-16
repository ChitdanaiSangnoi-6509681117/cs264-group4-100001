package cs.tu.studentSprint1.Controller;

import cs.tu.studentSprint1.Model.TeacherAppointment;
import cs.tu.studentSprint1.Repository.RequestFormRepository;
import cs.tu.studentSprint1.Repository.TeacherAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class showController {
    @Autowired
    private RequestFormRepository requestFormRepository;
    @Autowired
    private TeacherAppointmentRepository teacherAppointmentRepository;

    @GetMapping("/student_Appointment")
    public String studentAppointment(Model model) {
        List<TeacherAppointment> teacherAppointments = teacherAppointmentRepository.findTeacherAppointmentAll();
        model.addAttribute("TeacherAppointment",teacherAppointments);
        return "Student_Appointment";
    }



}
