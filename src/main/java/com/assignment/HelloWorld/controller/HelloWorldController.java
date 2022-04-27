package com.assignment.HelloWorld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("hello-rest")
    public String HelloRest() {
        return "Hello World";
    }

    @GetMapping(value = "hello-world", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String helloWorldHTML() {
        return "<html>\n <header><title>Hello World</title></header>\n <body>\n Hello world\n </body>\n </html>";
    }
}

