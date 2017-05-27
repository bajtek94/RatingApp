package com.example.ratingapp.web;

import com.example.ratingapp.model.Post;
import com.example.ratingapp.model.User;
import com.example.ratingapp.service.PostService;
import com.example.ratingapp.validator.PostValidator;
import com.example.ratingapp.validator.UserValidator;
import com.example.ratingapp.service.SecurityService;
import com.example.ratingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private PostService postService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;
//    @Autowired
//    private PostValidator postValidator;

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

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = {"/addPhoto"}, method = RequestMethod.GET)
    public String addPhoto(Model model) {
        model.addAttribute("postForm", new Post());
        return "addPhoto";
    }

    @RequestMapping(value = {"/addPhoto"}, method = RequestMethod.POST)
    public String addPhotoPost(@ModelAttribute("postForm") Post postForm, BindingResult bindingResult, Model model) {
//        postValidator.validate(postForm, bindingResult);
//        postService.save(postForm);
        return "welcome";
    }

//    @RequestMapping(value = "/admin/addEvent", method = RequestMethod.POST)
//    public String adminAddEvent(@ModelAttribute("eventForm") Event eventForm, BindingResult bindingResult, Model model,
//                                @RequestParam(value = "img") CommonsMultipartFile[] img) throws IOException {
//        eventValidator.setEditable(false);
//        eventValidator.validate(eventForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("gunTypeList", eventService.getListOfGuns());
//            model.addAttribute("refereeList", refereeService.getListOfReferees());
//            return "/admin/addEvent";
//        }
//
//        if (img != null && img.length > 0) {
//            for (CommonsMultipartFile aFile : img) {
//                eventForm.setImg(aFile.getBytes());
//            }
//        }
//
//        eventService.save(eventForm);
//
//        return "redirect:/admin/eventList";
//    }



}
