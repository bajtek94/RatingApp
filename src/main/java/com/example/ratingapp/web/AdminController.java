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

}
