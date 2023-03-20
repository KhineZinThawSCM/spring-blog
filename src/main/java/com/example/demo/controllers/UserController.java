package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;
import com.example.demo.services.user.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({ "/users", "/" })
    public ModelAndView getUsers() {
        ModelAndView mv = new ModelAndView("/users/list-users");
        List<User> list = userService.getUsers();
        mv.addObject("users", list);

        return mv;
    }

    @GetMapping("/createUser")
    public ModelAndView createUser() {
        ModelAndView mv = new ModelAndView("/users/create-users");
        User user = new User();
        mv.addObject("user", user);

        return mv;
    }

    @PostMapping("/storeUser")
    public String storeUser(@ModelAttribute User user) {
        userService.storeUser(user);

        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public ModelAndView editUser(@RequestParam Long userId) {
        ModelAndView mv = new ModelAndView("/users/create-users");
        User user =  userService.findById(userId);
        mv.addObject("user", user);

        return mv;
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        userService.deleteById(userId);
        return "redirect:/users";
    }
}
