package ru.evaproj.analyst.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class HelloController {

    @GetMapping(value = {"/"})
    public String helloWorldController() {
        return "index";
    }

}
