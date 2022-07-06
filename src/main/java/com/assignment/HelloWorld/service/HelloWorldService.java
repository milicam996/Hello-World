package com.assignment.HelloWorld.service;

import com.assignment.HelloWorld.model.HelloWorldModel;
import com.assignment.HelloWorld.repository.HelloWorldRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HelloWorldService {
    @Autowired
    HelloWorldRepository helloWorldRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    private static final Logger LOGGER = LogManager.getLogger(HelloWorldService.class);

    public String GetByLang(String lang) {
        if (activeProfile.equals("external")) {
            return GetByLangAPI(lang);
        } else {
            HelloWorldModel helloWorldModel = new HelloWorldModel();
            try {
                helloWorldModel = helloWorldRepository.GetByLang(lang);
            } catch (Exception exception) {
                LOGGER.error("Error occurred in GetByLang hello world service : {}", exception.getMessage());
            }

            if (helloWorldModel != null) {
                return helloWorldModel.getHw_translation();
            } else {
                return "Unknown language";
            }
        }
    }

    public void saveOrUpdate(HelloWorldModel language) {
        try {
            helloWorldRepository.save(language);
        } catch (Exception exception) {
            LOGGER.error("Error occurred in hello world service while saving or updating : {}", exception.getMessage());
        }
    }

    private String GetByLangAPI(String lang) throws IllegalArgumentException {

        if (lang == null) {
            throw new IllegalArgumentException("Language not provided");
        }
        HttpResponse<String> response = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https:/oft-translator-text.p.rapidapi.com/translate?to%5B0%5D=" + lang + "&api-version=3.0&from=en&profanityAction=NoAction&textType=plain"))
                    .header("content-type", "application/json")
                    .header("X-RapidAPI-Host", "microsoft-translator-text.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "7c486caf66msh7bec070c1113d78p1ea0f7jsne1436838fe73")
                    .method("POST", HttpRequest.BodyPublishers.ofString("[\r\n    {\r\n        \"Text\": \"Hello World.\"\r\n    }\r\n]"))
                    .build();
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException | SecurityException exception) {
            LOGGER.error("Error occurred while sending HTTP request: {}", exception.getMessage());
        }
        return null;
    }
}
