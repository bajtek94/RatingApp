package com.example.ratingapp.web;

import com.example.ratingapp.model.User;
import com.example.ratingapp.service.SecurityService;
import com.example.ratingapp.service.UserService;
import com.example.ratingapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bajtek on 12.05.2017.
 */
@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(Model model){
        return"admin_welcome";
    }

    @RequestMapping(value = {"/findPost"})
    public String findPost(Model model){
        return"admin_findPost";
    }

    @RequestMapping(value = {"/findUser"}, method = RequestMethod.GET)
    public String findUser(Model model){
        model.addAttribute("searchForm", new User());
        return"admin_findUser";
    }
    @RequestMapping(value = {"/findUser"}, method = RequestMethod.POST)
    public String findUserPost(@ModelAttribute("searchForm") User searchForm, Model model){
        List<User> list = userService.findByFillFields(searchForm);
        model.addAttribute("listOfFound", list);
        return"admin_foundUsers";
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

    @RequestMapping(value = {"/editUser-{userId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("userForm", user);
        return "admin_editUser";
    }


    @RequestMapping(value = { "/editUser-{userId}" }, method = RequestMethod.POST)
    public String changeUserInfo(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model, @PathVariable String userId) {
        userForm.setId(Long.parseLong(userId));
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin_editUser";
        }

        userService.updateUser(userForm);

        return "redirect:/admin/listUsers";

    }

}
