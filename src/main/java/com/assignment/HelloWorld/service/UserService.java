package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.model.UserModel;
import com.assignment.HelloWorld.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    public String GetUser(UserModel userModel) {
        UserModel user = new UserModel();
        try {
            user = userRepository.GetUser(userModel.getUsername(), userModel.getPassword());
        } catch (Exception exception) {
            LOGGER.error("Error occurred in user service : {}", exception.getMessage());
        }
        if (user != null) {
            return "Hello " + user.getUsername();
        } else {
            return "Wrong username or password";
        }
    }
}
