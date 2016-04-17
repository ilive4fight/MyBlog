package com.blog.controller;

import com.blog.model.User;
import com.blog.model.UserProfile;
import com.blog.service.ArticleService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Set;

/**
 * Created by semen on 15.04.2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    ArticleService articleService;


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to blog");
        model.addAttribute("articles", articleService.getAllArticles());
        return "welcome";
    }


    //////////////////////////////////////////////////////////USER REGISTRATION /////////////////////////////////////////////
    //////////////////////////////////////////////////////////USER REGISTRATION /////////////////////////////////////////////
    //////////////////////////////////////////////////////////USER REGISTRATION /////////////////////////////////////////////
    //////////////////////////////////////////////////////////USER REGISTRATION /////////////////////////////////////////////


    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registrtionPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
                                   BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "registration";
        }
        UserProfile uP = new UserProfile();
        uP.setId(1);
        user.addUserProfile(uP);
        userService.save(user);
        authenticateUserAndSetSession(user, request);
        model.addAttribute("user", getPrincipal() + " congratulate with registration");
        Set<UserProfile> t = user.getUserProfiles();
        for (UserProfile up : t) {
            System.out.println(up);
        }
        return "user/user";
    }



    ////////////////////////////////////////////////////////////// PRIVATE METHODS ///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////// PRIVATE METHODS ///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////// PRIVATE METHODS ///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////// PRIVATE METHODS ///////////////////////////////////////////////

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String ssoId = user.getSsoId();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(ssoId, password);
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
