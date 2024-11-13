package org.example.quora.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.quora.dtos.AnswerDtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<AnswerDto> getAnswersByQuestionId(UUID questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);

        if (answers.isEmpty()) {
            throw new EntityNotFoundException("No answers found for question ID " + questionId);
        }

        return answers.stream()
                .map(answer -> new AnswerDto(
                        answer.getUuid(),
                        answer.getQuestion().getId(),
                        answer.getUser().getId(),
                        answer.getText(),
                        LocalDateTime.ofInstant(answer.getCreatedAt().toInstant(), ZoneId.systemDefault())))
                .collect(Collectors.toList());
    }

    @Override
    public Answer createAnswer(AnswerDto answerDto) {
        User user = userRepository.findById(answerDto.getUserId()).get();
        Question question = questionRepository.findById(answerDto.getQuestionId()).get();

        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.setCreatedAt(new Date());
        answer.setUser(user);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}

