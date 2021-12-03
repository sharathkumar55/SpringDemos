package com.springDemoMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //we need a controller method to show initial show method
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloWorldform";
    }
    //we need a method to process form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloWorld";
    }


    /*new controller method to read form data and
    add data to the model*/
    @RequestMapping("/processFormVersionTwo")
    public String letsCapitalMessage(WebRequest request, Model model)
    {
        //read the data from the HTML form
        String theName = request.getParameter("studentname");

        //convert the data to all capitals
        theName = theName.toUpperCase();

        //create message
        String result = "Hello " + theName;

        //add message to the model
        model.addAttribute("message",result);
        return "helloWorld";
    }



    @RequestMapping("/processFormVersionThree")
    public String letsCapitalMessageVersion2(@RequestParam("studentname") String theName, Model model)
    {
        //read the data from the HTML form
      //  String theName = request.getParameter("studentname");

        //convert the data to all capitals
        theName = theName.toUpperCase();

        //create message
        String result = "Hi " + theName;

        //add message to the model
        model.addAttribute("message",result);
        return "helloWorld";
    }
}
