package org.example.quora.service;


import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    public List<AnswerDto> getAnswersByQuestionId(Long questionId);

    public String createAnswer(AnswerDto answerDto);
}
