package ru.evaproj.analyst.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evaproj.analyst.repos.UserRepo;
import ru.evaproj.analyst.services.UserService;

@RequestMapping
public class RegistrationController {

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String helloWorldController() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String helloWorldController(
            @RequestParam String name,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String email) {
        logger.info("Try registration: " + name + ", " + login + ", " + password + ", " + email);

        userService.registrationUser(name, login, password, email);

        return "login";
    }

}
