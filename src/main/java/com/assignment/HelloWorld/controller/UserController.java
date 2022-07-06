package com.assignment.HelloWorld.controller;

import com.assignment.HelloWorld.ErrorHandling.NullOrEmptyException;
import com.assignment.HelloWorld.model.UserModel;
import com.assignment.HelloWorld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "secure/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody UserModel user) throws NullOrEmptyException {
        return userService.GetUser(user);
    }
}

