package com.anders.spring_rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Stereotype
@RequestMapping("/hello") //Resource
public class AndersController {

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }
}
