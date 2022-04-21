package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listOfUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping(value = "/add")
    public String createNewUser(User user) {
        return "newUser";
    }

    @PostMapping(value = "/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", this.userService.findById(id));
        return "editUser";
    }

    @PostMapping(value = "/edit/{id}")
    public String UpdateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String editUser(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}