package org.example.quora.ServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.quora.dtos.AnswerDto;
import org.example.quora.models.Answer;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<AnswerDto> getAnswersByQuestionId(Long questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);

        if (answers.isEmpty()) {
            throw new EntityNotFoundException("No answers found for question ID " + questionId);
        }
        List<AnswerDto> answerDtos = new ArrayList<>();
        for (Answer answer : answers) {
            AnswerDto answerDto = AnswerDto.builder()
                    .questionId(questionId)
                    .text(answer.getText())
                    .build();
            answerDtos.add(answerDto);
        }

//        return answers.stream()
//                .map(answer -> new AnswerDto(
//                        answer.getUuid(),
//                        answer.getQuestion().getId(),
//                        answer.getUser().getId(),
//                        answer.getText(),
//                        LocalDateTime.ofInstant(answer.getCreatedAt().toInstant(), ZoneId.systemDefault())))
//                .collect(Collectors.toList());
        return answerDtos;
    }

    @Override
    public String createAnswer(AnswerDto answerDto) {
        User user = userRepository.findById(answerDto.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found") );
        Question question = questionRepository.findById(answerDto.getQuestionId()).orElseThrow(()-> new EntityNotFoundException("Question not found") );

        Answer answer = Answer.builder()
                .question(question)
                .user(user)
                .text(answerDto.getText())
                .build();
        answerRepository.save(answer);
        return "Answer posted successfully";
    }
}

