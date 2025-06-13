package com.hei.school.endpoint.rest.controller;

import com.hei.school.service.ChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HazavaoController {

    private final ChatGptService chatGptService;

    @Autowired
    public HazavaoController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @GetMapping("/hazavao")
    public String hazavao(@RequestParam String teny) {
        return chatGptService.getDefinitionInMalagasy(teny);
    }
}

