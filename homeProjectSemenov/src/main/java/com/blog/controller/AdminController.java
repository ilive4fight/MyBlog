package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by semen on 15.04.2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;


    @RequestMapping(value={""},method= RequestMethod.GET)
    public String adminPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }


    private String getPrincipal() {
        String userName=null;
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            userName=((UserDetails)principal).getUsername();
        }else{
            userName=principal.toString();
        }
        return userName;
    }
}
