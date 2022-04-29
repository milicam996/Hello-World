package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.model.HelloWorldModel;
import com.assignment.HelloWorld.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Autowired
    HelloWorldRepository helloWorldRepository;

    public String GetByLang(String lang) {
        HelloWorldModel helloWorldModel = helloWorldRepository.GetByLang(lang);
        return helloWorldModel.getHw_translation();
    }

}
