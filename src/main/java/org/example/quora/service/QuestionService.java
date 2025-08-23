package org.example.quora.service;


import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public Question createQuestion(QuestionDto questionDto);
    public Question updateQuestion(QuestionDto questionDto, Long questionId);

    List<Question> getAllQuestionsByUser(Long userId);
}
