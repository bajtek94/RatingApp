package com.example.ratingapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bajtek on 12.05.2017.
 */
@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(Model model){
        return"admin_welcome";
    }

    @RequestMapping(value = {"/findPost"})
    public String findPost(Model model){
        return"admin_findPost";
    }

    @RequestMapping(value = {"/findUser"})
    public String findUser(Model model){
        return"admin_findUser";
    }

    @RequestMapping(value = {"/listPosts"})
    public String listPosts(Model model){
        return"admin_listPosts";
    }

    @RequestMapping(value = {"/listUsers"})
    public String listUsers(Model model){
        return"admin_listUsers";
    }

}
