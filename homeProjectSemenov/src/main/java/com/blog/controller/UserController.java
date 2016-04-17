package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.User;
import com.blog.model.UserProfile;
import com.blog.service.UserProfileService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* Created by semen on 13.04.2016.
*/
@Controller
@RequestMapping("/user")
public class UserController {


    /////////////////////////////////////////////// SERVICES ////////////////////////////////////////////////////

    @Autowired
    UserService userService;


    @Autowired
    UserProfileService userProfileService;


    ////////////////////////////////////////////  CONTROLLER  /////////////////////////////////////////////
    ////////////////////////////////////////////  CONTROLLER  /////////////////////////////////////////////
    ////////////////////////////////////////////  CONTROLLER  /////////////////////////////////////////////
    ////////////////////////////////////////////  CONTROLLER  /////////////////////////////////////////////


    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
                                   BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }
        userService.save(user);

        model.addAttribute("success", "User " + user.getSsoId() + " has been registered successfully");
        return "success";
    }


    @RequestMapping(value={""},method=RequestMethod.GET)
    public String userPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        User user = userService.findBySso(getPrincipal());
        List<Article> listArticles = user.getArticles();
        model.addAttribute("articles",listArticles);
        return "user";}


    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "allusers";
    }
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user  = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "userEdit";
    }

    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(User user, ModelMap model, @PathVariable int id) {
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getSsoId()  + " updated successfully");
        return "success";
    }

//    @RequestMapping(value = {"/articles-{id}"},method = RequestMethod.GET)
//    public



    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(userService.findById(id));
        return "redirect:/admin";
    }


    //////////////////////////////////////////////////////    REST   ///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////    REST   ///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////    REST   ///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////    REST   ///////////////////////////////////////////////////////////


    @RequestMapping(value = "/allUsersRest", produces = {
            MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers1() {
        return userService.getAllUsers();
    }


    @RequestMapping(value = { "/rest/delete-user-{id}" }, produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    @ResponseBody
    public String deleteUserRest(@PathVariable int id) {
        if(userService.findById(id)!=null){
        userService.deleteUser(userService.findById(id));
        return "Success delete";}
        else return "Already delete";
    }





    /////////////////////////////////////////////////////////////////  METHODS&ATTRIBUTES  //////////////////////////////////////
    /////////////////////////////////////////////////////////////////  METHODS&ATTRIBUTES  //////////////////////////////////////
    /////////////////////////////////////////////////////////////////  METHODS&ATTRIBUTES  //////////////////////////////////////
    /////////////////////////////////////////////////////////////////  METHODS&ATTRIBUTES  //////////////////////////////////////


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
