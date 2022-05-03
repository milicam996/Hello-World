package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.model.UserModel;
import com.assignment.HelloWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String GetUser(UserModel userModel) {
        UserModel user = userRepository.GetUser(userModel.getUsername(),userModel.getPassword());
        return userModel.getUsername();
    }
}
