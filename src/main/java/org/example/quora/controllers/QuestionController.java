package org.example.quora.controllers;



import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/addquestion")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto questionDto) {
        Question question = questionService.createQuestion(questionDto);
        return ResponseEntity.ok(question);
    }

    @PutMapping("/updatequestion/{questionId}")
    public ResponseEntity<Question> updateQuestion(@RequestBody QuestionDto questionDto,@PathVariable UUID questionId) {
        Question question= questionService.updateQuestion(questionDto,questionId);
        return ResponseEntity.ok(question);
    }
}
