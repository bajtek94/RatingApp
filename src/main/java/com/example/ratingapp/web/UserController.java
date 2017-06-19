package com.example.ratingapp.web;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.model.User;
import com.example.ratingapp.service.PostService;
import com.example.ratingapp.validator.PostValidator;
import com.example.ratingapp.validator.UserValidator;
import com.example.ratingapp.service.SecurityService;
import com.example.ratingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PostService postService;
    @Autowired
    private PostValidator postValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");


        return "login";
    }

    @RequestMapping(value = {"/{pageNumber}", "/welcome/{pageNumber}"}, method = RequestMethod.GET)
    public String welcome(@PathVariable Integer pageNumber, Model model) {
        Page<Post> page = postService.getPostLog(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("postList", page.getContent());
        model.addAttribute("welcome", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        //model.addAttribute("postList", postService.getPostList());
        return "welcome";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomeRedirect() {
        return "redirect:/1";
    }


    @RequestMapping(value = { "/addPhoto" }, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String addPost(Model model) {
        model.addAttribute("postForm", new Post());
        return "addPhoto";
    }

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());

    }

    @RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
    public String addPhoto(@ModelAttribute("postForm") Post postForm, BindingResult bindingResult, Model model,
                                @RequestParam(value = "img") CommonsMultipartFile[] img) throws IOException {
        postValidator.validate(postForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/addPhoto";
        }


        if (img != null && img.length > 0) {
            for (CommonsMultipartFile aFile : img) {
                postForm.setImg(aFile.getBytes());
            }
        }

        postService.save(postForm);

        return "redirect:/welcome";
    }


    @RequestMapping(value = {"/", "/welcome", "/{pageNumber}", "/welcome/{pageNumber}"}, method = RequestMethod.POST)
    public String searchAll(@RequestParam(value = "searchText") String searchText, Model model) {
        model.addAttribute("searchText", searchText);
        return "redirect:/searchAll";
    }


    @RequestMapping(value = {"/searchAll"}, method = RequestMethod.GET)
    public String searchAlla(@ModelAttribute("searchText") String searchText, Model model) {
        List<User> list = userService.findByText(searchText);
        model.addAttribute("searchList", list);
        return "/searchAll";
    }

    @RequestMapping(value = {"/addLike-{postId}"}, method = RequestMethod.GET)
    public String addLike(@PathVariable String postId) {
        postService.addLike(postService.findById(postId));
        return "redirect:/";
    }

    @RequestMapping(value = {"/addDislike-{postId}"}, method = RequestMethod.GET)
    public String addDislike(@PathVariable String postId) {
        postService.addDislike(postService.findById(postId));
        return "redirect:/";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied() {
        return "403";
    }

}
