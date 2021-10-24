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
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String postLoginData(
            @RequestParam UserDTO user
            ) {
        logger.info("Try to login: " + user.getLogin() + ", " + user.getPassword());

        UserDTO userDto = userService.checkUser(user);

        return "login";
    }

}
