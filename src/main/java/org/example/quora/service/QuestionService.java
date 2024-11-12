package org.example.quora.service;


import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface QuestionService {
    public Question createQuestion(QuestionDto questionDto);
    public Question updateQuestion(QuestionDto questionDto, UUID questionId);

}
