package ru.evaproj.analyst.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.services.UserService;


@RequestMapping("/rest")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public String helloWorldController(
            @RequestParam String login,
            @RequestParam String password
        ) {
        logger.info("Try to login: " + login + ", " + password);

        UserDTO userDto = userService.checkUser(login, password);

        return "login";
    }

}
