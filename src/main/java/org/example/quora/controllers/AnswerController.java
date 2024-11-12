package org.example.quora.controllers;

import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerRepository answerRepository;

    public AnswerController(AnswerService answerService, AnswerRepository answerRepository) {
        this.answerService = answerService;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/answers")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @PostMapping("/addanswer/{questionId}/{answerId}")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDto answerDto, @PathVariable UUID questionId,@PathVariable UUID answerId) {
        Answer answer= answerService.createAnswer(answerDto, questionId, answerId);
        return ResponseEntity.ok(answer);
    }

    @PutMapping("/updateans/{answerId}")
    public ResponseEntity<Answer> updateAnswer(@RequestBody AnswerDto answerDto, @PathVariable UUID answerId) {
        Answer answer=answerService.updateAnswer(answerDto,answerId);
        return ResponseEntity.ok(answer);
    }
}
