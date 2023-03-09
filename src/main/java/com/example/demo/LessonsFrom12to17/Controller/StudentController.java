package com.example.demo.LessonsFrom12to17.Controller;

import com.example.demo.LessonsFrom12to17.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "PreviousLessons/student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("Student :" + student.getFirstName() + " and " + student.getLastName()+ " and " + student.getCountry()+ " and " + student.getOptionsOfCountry());
        return "PreviousLessons/student-confirmation";
    }

}
