package com.assignment.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("hello-rest")
    public String HelloRest() {
        return "Hello World";
    }
}
