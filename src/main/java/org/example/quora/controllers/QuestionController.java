package org.example.quora.controllers;


import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class QuestionController {


    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    public QuestionController(final QuestionRepository questionRepository, final QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }


    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @PostMapping("/addquestion/{userId}")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto questionDto,@PathVariable UUID userId) {
        Question question = questionService.createQuestion(questionDto, userId);
        return ResponseEntity.ok(question);
    }
}
