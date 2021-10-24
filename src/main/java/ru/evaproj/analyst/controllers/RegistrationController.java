package ru.evaproj.analyst.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.services.UserService;

@Controller
@RequestMapping("/rest")
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
            @RequestParam UserDTO user) {
        logger.info("Try registration: " + toString());

        userService.registrationUser(user);

        return "login";
    }

}
