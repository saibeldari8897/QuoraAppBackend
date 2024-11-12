package org.example.quora.service;

import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerServiceImpl implements AnswerService {



    private AnswerRepository answerRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    public AnswerServiceImpl(AnswerRepository answerRepository,QuestionRepository questionRepository,UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Answer> getAnswer(long id) {
        return Optional.empty();
    }

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer createAnswer(AnswerDto answerDto, UUID questionId, UUID userId) {
        Question idOfQuestion = questionRepository.findById(questionId).get();
        User idOfUser = userRepository.findById(userId).get();
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.setCreatedAt(new Date());
        answer.setQuestion(idOfQuestion);
        answer.setUser(idOfUser);
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Answer updateAnswer( AnswerDto answerDto, UUID questionId) {
        Answer answer = answerRepository.findById(questionId).get();
        answer.setText(answerDto.getText());
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public void deleteAnswer(UUID answerId, UUID questionId, UUID userId) {

    }

    @Override
    public void deleteAllAnswers() {

    }
}
