package com.example.ratingapp.web;

import com.example.ratingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bajtek on 12.05.2017.
 */
@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = {"/listUsers"}, method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("userList", userService.getUsersList());
        return"admin_listUsers";
    }

    @RequestMapping(value = {"/deleteUser-{userId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return "redirect:/admin/listUsers";
    }

}
