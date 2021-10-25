package ru.evaproj.analyst.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.exceptions.EmaiAlreadyExistException;
import ru.evaproj.analyst.exceptions.UserAlreadyExistException;
import ru.evaproj.analyst.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public String helloWorldController(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public ModelAndView helloWorldController(
            @ModelAttribute("user") @Valid UserDTO userDto,
            HttpServletRequest request,
            ModelAndView mav,
            Errors errors) {
        logger.info("Try registration: " + toString());

        try {
            userService.registrationUser(userDto);
        } catch (UserAlreadyExistException | EmaiAlreadyExistException ex) {
            mav.addObject("message", ex.getMessage());
        }

        return mav;
    }

}
