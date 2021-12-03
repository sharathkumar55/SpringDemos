package com.springDemoMVC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
@Controller
public class ConflictDemo {

    @RequestMapping("/showForm")
    public String conflictMethod()
    {
        return "conflict";
    }
}
