package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.User;
import com.blog.service.ArticleService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by semen on 14.04.2016.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/newarticle", method = RequestMethod.GET)
    public String newArticle(ModelMap model) {
       Article article = new Article();
        model.addAttribute("article", article);
        return "newarticle";
    }
    @RequestMapping(value = "/newarticle", method = RequestMethod.POST)
    public String newArticleCreate(Article article,BindingResult result, ModelMap model) {
        User user =userService.findBySso(getPrincipal());
        article.setUser(user);
        articleService.saveArticle(article);
        model.addAttribute("article", article);
        model.addAttribute("articles",user.getArticles() );
        return "redirect:/user";
    }
    @RequestMapping(value = "new", produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public Article newArticleRest(@RequestParam("text")String text, @RequestParam("title")String title) {
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);
        article.setUser(userService.findBySso(getPrincipal()));
        articleService.saveArticle(article);
        return article;
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
