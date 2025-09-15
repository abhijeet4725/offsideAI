package com.abhijeet.offsideAi.prompt.controller;

import com.abhijeet.offsideAi.prompt.service.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/football")
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/ask")
    public FootballAnswerResponse askQuestion(@RequestBody QuestionRequest request) {
        String answer = geminiService.askFootballQuestion(request.getQuestion());
        return new FootballAnswerResponse(answer);
    }

    // DTO for user request
    public static class QuestionRequest {
        private String question;

        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }
    }

    // DTO for response
    public static class FootballAnswerResponse {
        private String answer;

        public FootballAnswerResponse(String answer) { this.answer = answer; }
        public String getAnswer() { return answer; }
        public void setAnswer(String answer) { this.answer = answer; }
    }
}
