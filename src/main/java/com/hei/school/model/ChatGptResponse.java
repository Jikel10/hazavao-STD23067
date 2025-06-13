package com.hei.school.model;


import lombok.Getter;

import java.util.List;

@Getter
public class ChatGptResponse {

    private List<Choice> choices;

    public static class Choice {
        private Message message;

        public Message getMessage() {
            return message;
        }
    }

    public static class Message {
        private String content;

        public String getContent() {
            return content;
        }
    }
}

