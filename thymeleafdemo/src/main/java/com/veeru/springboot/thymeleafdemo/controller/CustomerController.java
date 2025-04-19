package com.veeru.springboot.thymeleafdemo.controller;

import com.veeru.springboot.thymeleafdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //add initbinder .. to convert trim input strings
    //to remove leading and trailing whitespaces
    //resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/showCustomerForm")
    public String showForm(Model model) {

     model.addAttribute("customer" , new Customer());

     return "customer-form";
    }

    @PostMapping("/processCustomerForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }
}
