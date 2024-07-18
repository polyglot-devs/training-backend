package com.polyglot.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHome {
    @GetMapping
    public String welcome(){
        return "Welcome";
    }
}
