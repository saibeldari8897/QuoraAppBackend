package org.example.quora.service;


import org.example.quora.dtos.AnswerDtos.AnswerDto;
import org.example.quora.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AnswerService {
    public List<AnswerDto> getAnswersByQuestionId(UUID questionId);

    public Answer createAnswer(AnswerDto answerDto);
}
