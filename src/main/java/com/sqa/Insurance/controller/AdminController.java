package com.sqa.Insurance.controller;

import com.sqa.Insurance.model.User;
import com.sqa.Insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id);
        model.addAttribute(user);
        return "profile";
    }

    @GetMapping("/user/create")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "userCreate";
    }

    @PostMapping("/user")
    public String storeUser(@ModelAttribute User user, Model model){
        try {
            user.setIs_active(false);
            user.setUsername(user.getType() + String.valueOf((int)(Math.random()*100000)+10000) + String.valueOf((int)(Math.random()*100000)+10000));
            userRepository.save(user);
            return "userCreate";

        }catch (Exception e){
            model.addAttribute("error", true);
            return "userCreate";
        }
    }

}
