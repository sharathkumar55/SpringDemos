package com.springDemoMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Console;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel)
    {
        //create a student object
        Student theStudent = new Student();

        //add Student object to model
        theModel.addAttribute("student",theStudent);
        return "showform";
    }
    @RequestMapping("/processform")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {

        //just to know whether model attribute is populated the object
       // System.out.println("Students details are "+theStudent.getFirstName()+" "+theStudent.getLastName());

        return "studentconfirmation";
    }
}
