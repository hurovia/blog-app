package com.hurovia.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class Controller {

    @GetMapping("/greet")
    public String greetUser(){
        return "Hello! User";
    }
}
