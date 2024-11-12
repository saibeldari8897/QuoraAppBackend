package org.example.quora.service;


import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface AnswerService {
    public Optional<Answer> getAnswer(long id);
    public List<Answer> getAllAnswers();
    public Answer createAnswer(AnswerDto answerDto, UUID questionId,UUID userId);
    public Answer updateAnswer(AnswerDto answerDto, UUID questionId);
    public void deleteAnswer(UUID answerId, UUID questionId, UUID userId);
    public void deleteAllAnswers();

}
