package com.assignment.HelloWorld.controller;

import com.assignment.HelloWorld.ErrorHandling.NullOrEmptyException;
import com.assignment.HelloWorld.model.UserModel;
import com.assignment.HelloWorld.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.time.LocalTime.now;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserControllerIntegrationTest {

    @Autowired
    UserController userController;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    @BeforeAll
    static void beforeClass() {
        LOGGER.info("Test UserController has started, time:" + now());
    }

    @AfterAll
    static void afterClass() {
        LOGGER.info("Test UserController has ended, time:" + now());
    }

//    @BeforeEach
//    void beforeEach() {
//        LOGGER.info("Test User has started, time:"+ now());
//    }
//
//    @AfterEach
//    void afterEach() {
////        LOGGER.info("Test User has ended, time:"+ now());
//    }

    @Test
    public void getValidUser() throws NullOrEmptyException {

        LOGGER.info("Test getValidUser has started, time:" + now());

        UserModel userModelMock = new UserModel();
        userModelMock.setUsername("Milica");
        userModelMock.setPassword("milica1");

        String result = userController.create(userModelMock);
        Assertions.assertEquals("Hello Milica", result);

        LOGGER.info("Test getValidUser has ended, time:" + now());
    }

    @Test
    public void getInvalidUser() throws NullOrEmptyException {

        LOGGER.info("Test getInvalidUser has started, time:" + now());

        UserModel userModelMock = new UserModel();
        userModelMock.setUsername("Mimi");
        userModelMock.setPassword("mimi");

        String result = userController.create(userModelMock);
        Assertions.assertEquals("Wrong username or password", result);

        LOGGER.info("Test getInvalidUser has ended, time:" + now());
    }
}