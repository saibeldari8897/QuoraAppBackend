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
    public Optional<Question> getQuestionById(int id);
    public List<Question> getAllQuestions();
    public List<Question> getQuestionsByAuthor(String author);
    public Question createQuestion(QuestionDto questionDto, UUID userId);
    public Question updateQuestion(Question question);
    public void deleteQuestion(int id);
    public void deleteQuestionByAuthor(String author);
    public void deleteQuestionByQuestionId(int id);

}
