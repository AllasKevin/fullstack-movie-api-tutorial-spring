package com.example.moviestutorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/root")
    public String apiRoot(){
        return "hejhej";
    }
}
