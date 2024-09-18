package com.practice.PMsystem.controller;

import com.practice.PMsystem.entity.User;
import com.practice.PMsystem.services.UserService;
import com.practice.PMsystem.services.UserServiceImpl;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listOfUsers")
    public String showUserList(Model model) {

        // getting List of Users and sending it to view page named list-of-users.html
        List<User> userList = userService.findAllByOrderByIdAsc();
        model.addAttribute("listOfUsers", userList);

        return "list-of-users";
    }

    @GetMapping("/listOfUsersByOrderByUsernameAsc")
    public String showUserListByOrderByUsernameAsc(Model model) {

        // getting List of Users and sending it to view page named list-of-employees.html
        List<User> userList = userService.findAllByOrderByUsernameAsc();
        model.addAttribute("listOfUsers", userList);

        return "list-of-users";
    }

    @GetMapping("/listOfUsersByOrderByEnabledAsc")
    public String showUserListByOrderByUEnabledAsc(Model model) {

        // getting List of Users and sending it to view page named list-of-employees.html
        List<User> userList = userService.findAllByOrderByEnabledAsc();
        model.addAttribute("listOfUsers", userList);

        return "list-of-users";
    }

    @GetMapping("/newUserForm")
    public String showNewUserForm(Model model) {

        // create model attribute to bind form data
        User newUser = new User();
        model.addAttribute("newUser", newUser);

        return "user-form";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("newUser") User newUser) {
        userService.saveUser(newUser);

        // use a redirect to prevent duplicate submissions
        return "redirect:/listOfUsers";
    }

    @GetMapping("/showFromForUserUpdate")
    public String showFormForUserUpdate(@RequestParam("userId") int id, Model model) {

        User tempUser = userService.findUserById(id);
        model.addAttribute("userForUpdate", tempUser);

        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUserById(id);

        return "redirect:/listOfUsers";
    }
}
