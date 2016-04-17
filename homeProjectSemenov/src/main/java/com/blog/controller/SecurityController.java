package com.blog.controller;

import com.blog.model.User;
import com.blog.model.UserProfile;
import com.blog.service.UserProfileService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by semen on 12.04.2016.
 */
@Controller
public class SecurityController {

    @Autowired
    UserProfileService userProfileService;


    @RequestMapping(value = {"/security/login"}, method=RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value={"/security/logout"},method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request,HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return "redirect:/security/login?logout";
    }

    @RequestMapping(value={"/security/Access_Denied"},method=RequestMethod.GET)
    public String accessDeniedPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
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

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }


}
