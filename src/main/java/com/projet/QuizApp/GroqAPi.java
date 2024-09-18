package com.projet.QuizApp;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
@Service

public class GroqAPi {



        private final String GROQ_API_URL = "https://api.groq.com/v1/chat/completions";
        private final String API_KEY = "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";

        public String getChatResponse(String userMessage) {
            RestTemplate restTemplate = new RestTemplate();

            // Create the payload
            String requestBody = "{ \"messages\": [{\"role\": \"user\", \"content\": \"" + userMessage + "\"}], \"model\": \"llama3-8b-8192\", \"temperature\": 1, \"max_tokens\": 1024, \"top_p\": 1, \"stream\": false, \"stop\": null }";

            // Set headers, including the API key
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.set("Content-Type", "application/json");

            // Make the POST request
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(GROQ_API_URL, HttpMethod.POST, entity, String.class);

            return response.getBody();
        }
    }


