package com.assignment.HelloWorld.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.time.LocalTime.now;


public class UserModelTest {

    private static final Logger LOGGER = LogManager.getLogger(UserModel.class);

    @Test
    public void userTest() {

        LOGGER.info("Test userTest has started, time:" + now());

        UserModel userModel = new UserModel();
        userModel.setUsername("Milica");
        userModel.setPassword("Milica1");

        String username = userModel.getUsername();
        Assertions.assertEquals("Milica", username);

        LOGGER.info("Test userTest has ended, time:" + now());
    }
}
