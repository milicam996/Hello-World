package com.assignment.HelloWorld.controller;

import com.assignment.HelloWorld.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.LocalTime.now;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldControllerTest {

    @Autowired
    MockMvc mockMvc;

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
    void helloRest() throws Exception {

        LOGGER.info("Test helloRest has started, time:" + now());

        HelloWorldController controller = new HelloWorldController();
        String response = controller.HelloRest();
        assertEquals("Hello World", response);

        LOGGER.info("Test helloRest has ended, time:" + now());
    }

    @Test
    void helloWorldHTML() {

        LOGGER.info("Test helloWorldHTML has started, time:" + now());

        HelloWorldController controller = new HelloWorldController();
        String response = controller.helloWorldHTML();
        assertEquals("<html>\n <header><title>Hello World</title></header>\n <body>\n Hello world\n </body>\n </html>", response);

        LOGGER.info("Test helloWorldHTML has ended, time:" + now());
    }
}


