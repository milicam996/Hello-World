package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.ErrorHandling.NullOrEmptyException;
import com.assignment.HelloWorld.model.UserModel;
import com.assignment.HelloWorld.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    public String GetUser(UserModel userModel) throws NullOrEmptyException {

        if(userModel.getUsername() == null || userModel.getPassword() == null) {
            throw new NullOrEmptyException("Null or empty username or password");
        }
        try {
            UserModel user = userRepository.GetUser(userModel.getUsername(), userModel.getPassword());
            if (user != null) {
                return "Hello " + user.getUsername();
            } else {
                return "Wrong username or password";
            }
        } catch (NonTransientDataAccessException exception) {
            LOGGER.error("Error occurred in user service while getting user: {}", exception.getMessage());
        }
        return null;
    }
}
