package com.practice.PMsystem.controller;

import com.practice.PMsystem.entity.User;
import com.practice.PMsystem.services.UserService;
import com.practice.PMsystem.services.UserServiceImpl;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

@Controller
public class HomePageController {

    private UserService userService;

    // this deletes all white spaces in String's which are send back from html forms
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showHomePage() {

        return "home";
    }

    @GetMapping("/listOfEmployees")
    public String showEmployeeList(Model model) {

        // getting List of Employees and sending it to view page named list-of-employees.html
        List<User> userList = userService.findAllByOrderByIdAsc();
        model.addAttribute("listOfEmployees", userList);

        return "list-of-employees";
    }
}
