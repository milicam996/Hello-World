package com.assignment.HelloWorld.controller;

import com.assignment.HelloWorld.model.HelloWorldModel;
import com.assignment.HelloWorld.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.time.LocalTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    HelloWorldController helloWorldController;

    private static final Logger LOGGER = LogManager.getLogger(HelloWorldService.class);

    @BeforeAll
    static void beforeClass() {
        LOGGER.info("Test HelloWorldController has started, time:" + now());
    }

    @AfterAll
    static void afterClass() {
        LOGGER.info("Test HelloWorldController has ended, time:" + now());
    }

//    @BeforeEach
//    void beforeEach() {
//        LOGGER.info("Test helloWorld has started, time:"+ now());
//    }
//
//    @AfterEach
//    void afterEach() {
//        LOGGER.info("Test helloWorld has ended, time:"+ now());
//    }

    @Test
    public void GetByLang() {

        LOGGER.info("Test GetByLang has started, time:" + now());

        String result = helloWorldController.GetByLang("English");
        assertEquals("Hello world", result);

        LOGGER.info("Test GetByLang has ended, time:" + now());
    }

    @Test
    public void testSave() {

        LOGGER.info("Test testSave has started, time:" + now());

        HelloWorldModel helloWorldModelMock = new HelloWorldModel();
        helloWorldModelMock.setLang("Bosnian");
        helloWorldModelMock.setHw_translation("Zdravo svijete");

        int result = helloWorldController.saveLanguage(helloWorldModelMock);
        Assertions.assertEquals(11, result);

        LOGGER.info("Test testSave has ended, time:" + now());
    }
}
