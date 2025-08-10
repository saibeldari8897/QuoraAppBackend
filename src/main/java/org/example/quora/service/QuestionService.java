package org.example.quora.service;


import org.example.quora.dtos.QuestionDtos.QuestionDto;
import org.example.quora.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface QuestionService {
    public Question createQuestion(QuestionDto questionDto);
    public Question updateQuestion(QuestionDto questionDto, UUID questionId);

    List<Question> getAllQuestionsByUser(UUID userId);
}
