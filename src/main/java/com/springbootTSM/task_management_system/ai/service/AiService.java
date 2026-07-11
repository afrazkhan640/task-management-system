package com.springbootTSM.task_management_system.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AiService {

	@Value("${ai.api.key}")
	private String apiKey;
	
	private final WebClient webClient;

	
	
	public AiService(WebClient webClient) {
		super();
		this.webClient = webClient;
	}



	public String generateSubtasks(String title) {

	    try {

	        String prompt = """
	                Break this task into 5 smaller actionable subtasks:

	                Task: %s
	                """.formatted(title);

	        String requestBody = """
	                {
	                  "contents": [
	                    {
	                      "parts": [
	                        {
	                          "text": "%s"
	                        }
	                      ]
	                    }
	                  ]
	                }
	                """.formatted(prompt);

	        return webClient.post()
	                .uri("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey)

	                .header("Content-Type", "application/json")

	                .bodyValue(requestBody)

	                .retrieve()

	                .bodyToMono(String.class)

	                .block();

	    } catch (Exception e) {

	        return "AI service temporarily unavailable: "
	                + e.getMessage();
	    }
	}
	
	
}
