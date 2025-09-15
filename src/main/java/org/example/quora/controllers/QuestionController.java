package org.example.quora.controllers;



import org.example.quora.ApiResponses.LoginApiResponse;
import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//
//    @GetMapping("/questions")
//    public ResponseEntity<List<Question>> getAllQuestions() {
//        return ResponseEntity.ok(questionRepository.findAll());
//    }

    @PostMapping("/addquestion")
    public ResponseEntity<LoginApiResponse> createQuestion(@RequestBody QuestionDto questionDto) {
        String message = questionService.createQuestion(questionDto);
        LoginApiResponse loginApiResponse = LoginApiResponse.builder()
                .message(message)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .build();
        return ResponseEntity.ok(loginApiResponse);
    }

    @PutMapping("/updatequestion/{questionId}")
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionDto questionDto,@PathVariable Long questionId) {
        String questionRes= questionService.updateQuestion(questionDto,questionId);
        return ResponseEntity.ok(questionRes);
    }
    @GetMapping("/getQuestions/{userId}")
    public ResponseEntity<List<Question>> getAllQuestionsByUser(@PathVariable Long userId) {
        List<Question> questions = questionService.getAllQuestionsByUser(userId);
        return ResponseEntity.ok(questions);
    }
}
