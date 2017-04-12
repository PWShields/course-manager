package com.puffinpowered.coursemanager.controller.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pshields on 15/09/2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${homepage.image}")
    private String image;

    @RequestMapping(value = {"/", "/home"})
    public String home(Model model){
        model.addAttribute("image",image);
        return "home/home";
    }
}
