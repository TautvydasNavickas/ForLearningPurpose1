package com.example.demo.LessonsFrom12to17.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showFrom(){
        return "PreviousLessons/helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "PreviousLessons/helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude (HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo " + name;
        model.addAttribute("message", result);


        return "PreviousLessons/helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        name = name.toUpperCase();
        String result = "Hey " + name;
        model.addAttribute("message", result);


        return "PreviousLessons/helloworld";
    }


}
