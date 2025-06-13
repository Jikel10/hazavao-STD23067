package com.hei.school.model;


import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ChatGptRequest {
    private String model;
    private List<Map<String, String>> messages;

    public ChatGptRequest(String model, List<Map<String, String>> messages) {
        this.model = model;
        this.messages = messages;
    }

}

