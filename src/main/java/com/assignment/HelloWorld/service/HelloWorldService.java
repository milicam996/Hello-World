package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.model.HelloWorldModel;
import com.assignment.HelloWorld.repository.HelloWorldRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    @Autowired
    HelloWorldRepository helloWorldRepository;

    private static final Logger LOGGER = LogManager.getLogger(HelloWorldService.class);

    public String GetByLang(String lang) {
        HelloWorldModel helloWorldModel=null;
        try {
          helloWorldModel = helloWorldRepository.GetByLang(lang);
        } catch (Exception exception) {
            LOGGER.error("Error occurred in business service : {}",exception.getMessage());
        }

        return helloWorldModel.getHw_translation();
    }


    public void saveOrUpdate(HelloWorldModel language) {
        helloWorldRepository.save(language);
    }
}
