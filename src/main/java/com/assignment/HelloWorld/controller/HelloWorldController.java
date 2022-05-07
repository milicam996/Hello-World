package com.assignment.HelloWorld.controller;

import com.assignment.HelloWorld.model.HelloWorldModel;
import com.assignment.HelloWorld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("/hello-rest")
    public String HelloRest() {
        return "Hello World";
    }

    @GetMapping(value = "hello-world", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String helloWorldHTML() {
        return "<html>\n <header><title>Hello World</title></header>\n <body>\n Hello world\n </body>\n </html>";
    }

    @GetMapping("/hello/{lang}")
    public String GetByLang(@PathVariable("lang") String lang) {
        return helloWorldService.GetByLang(lang);
    }

    @PostMapping("/new-language")
    public int saveLanguage(@RequestBody HelloWorldModel language) {
        helloWorldService.saveOrUpdate(language);
        return language.getId();
    }
}

