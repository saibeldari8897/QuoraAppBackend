package org.example.quora.controllers;

import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerRepository answerRepository;

    public AnswerController(AnswerService answerService, AnswerRepository answerRepository) {
        this.answerService = answerService;
        this.answerRepository = answerRepository;
    }

    @PostMapping("/answer")
    public ResponseEntity<Answer> createAnswer(@RequestBody AnswerDto answerDto) {
        Answer answer = answerService.createAnswer(answerDto);
        if (answerDto.getQuestionId() != null && answerDto.getUserId() != null) {
            return new ResponseEntity<Answer>(answerRepository.save(answer),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getanswerbyquestionid/{questionId}")
    public List<AnswerDto> getAnswersByQuestionId(@PathVariable Long questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    }

}
