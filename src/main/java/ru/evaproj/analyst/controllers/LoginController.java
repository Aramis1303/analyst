package ru.evaproj.analyst.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import ru.evaproj.analyst.dto.UserDTO;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new UserDTO());
        log.info("GET /login");
        return "login";
    }

}
