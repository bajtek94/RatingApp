package com.example.ratingapp.web;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.model.User;
import com.example.ratingapp.service.PostService;
import com.example.ratingapp.service.SecurityService;
import com.example.ratingapp.service.UserService;
import com.example.ratingapp.validator.PostValidator;
import com.example.ratingapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
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
    private PostValidator postValidator;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(Model model){
        return"admin_welcome";
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
    @RequestMapping(value = {"/findPost"}, method = RequestMethod.GET)
    public String findPost(Model model){
        model.addAttribute("searchForm", new Post());
        return"admin_findPost";
    }
    @RequestMapping(value = {"/findPost"}, method = RequestMethod.POST)
    public String findPostP(@ModelAttribute("searchForm") Post searchForm, Model model){
        List<Post> list = postService.findByTitle(searchForm.getTitle());
        List<Post> listD = postService.findByDescription(searchForm.getDescription());
        for (Post p: listD) {
            list.add(p);
        }
        model.addAttribute("listOfFound", list);
        return"admin_foundPosts";
    }

    @RequestMapping(value = {"/listPosts/{pageNumber}"}, method = RequestMethod.GET)
    public String listPosts(@PathVariable Integer pageNumber, Model model){
        Page<Post> page = postService.getPostLog(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("postList", page.getContent());
        model.addAttribute("listPosts", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return"admin_listPosts";
    }

    @RequestMapping(value = {"/listPosts"}, method = RequestMethod.GET)
    public String welcomeRedirect() {
        return "redirect:/admin/listPosts/1";
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

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied() {
        return "403";
    }

    @RequestMapping(value = {"/deletePost-{postId}"}, method = RequestMethod.GET)
    public String deletePost(@PathVariable String postId) {
        postService.deletePostById(postId);
        return "redirect:/admin/listPosts";
    }
    @RequestMapping(value = {"/editPost-{postId}"}, method = RequestMethod.GET)
    public String editPost(@PathVariable String postId, Model model) {
        Post post = postService.findById(postId);
        model.addAttribute("postForm", post);
        return "admin_editPost";
    }

    @RequestMapping(value = { "/editPost-{postId}" }, method = RequestMethod.POST)
    public String changePostInfo(@ModelAttribute("postForm") Post postForm, BindingResult bindingResult, Model model, @PathVariable String postId) {
        postForm.setId(Long.parseLong(postId));
        postValidator.validate(postForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin_editPost";
        }

        postService.updatePost(postForm);

        return "redirect:/admin/listPosts";

    }
}
