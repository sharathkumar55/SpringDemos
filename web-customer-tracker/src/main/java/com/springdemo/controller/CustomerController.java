package com.springdemo.controller;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

   //need to inject the customer DAO
   /* @Autowired
    private CustomerDAO customerDAO;*/

     //this is added beacuase we are using customer service
    @Autowired
    private CustomerService customerService;

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model theModel)
    {

        //get the customers from dao
        //List<Customer> theCustomers = customerDAO.getCustomers();
        //get the customers from service
       List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to model
        theModel.addAttribute("customers",theCustomers);
        return "listcustomers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        //create the model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customerform";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
    {
        //save the customer using our service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel)
    {
        //get the customer from our service
        Customer theCustomer =customerService.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        //send over the form
        return "customerform";
    }
    @GetMapping("/delete")
     public String deleteCustomer(@RequestParam("customerId") int theId)
    {
        //get the customer from our service
      //  Customer theCustomer =customerService.getCustomer(theId);
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";

    }
}
