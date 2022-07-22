package com.assignment.HelloWorld.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.time.LocalTime.now;

public class HelloWorldModelTest {

    private static final Logger LOGGER = LogManager.getLogger(HelloWorldModel.class);

    @Test
    public void helloWorldTest() {

        LOGGER.info("Test helloWorldTest has started, time:" + now());

        HelloWorldModel helloWorldModel = new HelloWorldModel();
        helloWorldModel.setId(12);
        helloWorldModel.setLang("Polish");
        helloWorldModel.setHw_translation("Witaj świecie");

        String hw_translation = helloWorldModel.getHw_translation();
        Assertions.assertEquals("Witaj świecie", hw_translation);

        LOGGER.info("Test helloWorldTest has ended, time:" + now());
    }
}

