package org.example.quora.service;

import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }




    @Override
    public Question createQuestion(QuestionDto questionDto) {

        try {
            Question question = new Question();
            question.setTitle(questionDto.getTitle());
            question.setBody(questionDto.getBody());
            question.setCreatedAt(new Date());
             User user = userRepository.findById(questionDto.getUserId()).get();
             if (user != null) {
                 question.setUser(user);
             } else {
                 return null;
             }
            return questionRepository.save(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Question updateQuestion(QuestionDto questionDto,UUID questionId) {
        try{
            Question question1 = questionRepository.findById(questionId).get();
           question1.setTitle(questionDto.getTitle());
           question1.setBody(questionDto.getBody());
           return questionRepository.save(question1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
