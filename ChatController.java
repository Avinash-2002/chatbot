//package main.java.com.example.demo.controller;

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.MilvusService;
import com.example.demo.service.LanguageModelService;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final MilvusService milvusService;
    private final LanguageModelService languageModelService;

    public ChatController(MilvusService milvusService, LanguageModelService languageModelService) {
        this.milvusService = milvusService;
        this.languageModelService = languageModelService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String userQuery) {
        try {
            String retrievedContext = milvusService.retrieveRelevantContext(userQuery);
            return languageModelService.generateResponse(userQuery, retrievedContext);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to generate response.";
        }
    }
}
