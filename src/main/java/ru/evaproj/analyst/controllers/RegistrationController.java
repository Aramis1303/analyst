package ru.evaproj.analyst.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.evaproj.analyst.dto.UserDTO;
import ru.evaproj.analyst.exceptions.EmaiAlreadyExistException;
import ru.evaproj.analyst.exceptions.UserAlreadyExistException;
import ru.evaproj.analyst.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Controller
public class RegistrationController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/registration")
    public String helloWorldController(Model model) {
        model.addAttribute("user", new UserDTO());
        log.info("GET /registration");
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String helloWorldController(
            @ModelAttribute("user") @Valid UserDTO userDto,
            HttpServletRequest request,
            Model model,
            Errors errors)
    {

        try {
            log.info("POST /registration");
            log.info("user: " + userDto);
            userDetailsService.registrationUser(userDto);
            return "redirect:/login";
        } catch (UserAlreadyExistException | EmaiAlreadyExistException ex) {
            model.addAttribute("message", ex.getMessage());
            return "registration";
        }


    }

}
