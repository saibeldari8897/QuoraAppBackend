package org.example.quora.controllers;

import org.example.quora.ApiResponses.LoginApiResponse;
import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/postanswer")
    public ResponseEntity<LoginApiResponse> createAnswer(@RequestBody AnswerDto answerDto) {
        String message = answerService.createAnswer(answerDto);
        LoginApiResponse loginApiResponse = LoginApiResponse.builder()
                .status(HttpStatus.CREATED.value())
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(loginApiResponse);
    }

    @GetMapping("/getanswerbyquestionid/{questionId}")
    public ResponseEntity<List<AnswerDto>> getAnswersByQuestionId(@PathVariable Long questionId){
        return ResponseEntity.ok(answerService.getAnswersByQuestionId(questionId));
    }

}
