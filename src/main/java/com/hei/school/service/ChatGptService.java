package com.hei.school.service;

import com.hei.school.model.ChatGptRequest;
import com.hei.school.model.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

@Service
public class ChatGptService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String getDefinitionInMalagasy(String teny) {
        try {
            String prompt = "Hazavao amin'ny teny malagasy ny dikan'ny teny: " + teny;

            ChatGptRequest request = new ChatGptRequest(
                    "gpt-3.5-turbo",
                    List.of(Map.of("role", "user", "content", prompt))
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<ChatGptRequest> entity = new HttpEntity<>(request, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<ChatGptResponse> response = restTemplate.postForEntity(
                    "https://api.openai.com/v1/chat/completions",
                    entity,
                    ChatGptResponse.class
            );

            if (response.getBody() != null && !response.getBody().getChoices().isEmpty()) {
                return response.getBody().getChoices().get(0).getMessage().getContent().trim();
            }

            return "Tsy hita ny famaritana.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur interne : " + e.getMessage();
        }
    }

}

