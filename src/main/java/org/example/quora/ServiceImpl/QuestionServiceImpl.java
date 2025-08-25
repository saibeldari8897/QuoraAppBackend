package org.example.quora.ServiceImpl;

import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }




    @Override
    public String createQuestion(QuestionDto questionDto) {

        User user = userRepository.findById(questionDto.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        Question question = Question.builder()
                .user(user)
                .body(questionDto.getBody())
                .build();
        questionRepository.save(question);
        return "Question created successfully";
    }

    @Override
    public Question updateQuestion(QuestionDto questionDto,Long questionId) {
        try{
            Question question1 = questionRepository.findById(questionId).get();
           question1.setBody(questionDto.getBody());
           return questionRepository.save(question1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getAllQuestionsByUser(Long userId) {
        List<Question> questions = questionRepository.findByUserId(userId);
        if (questions != null) {
            return questions;
        }
        return null;
    }
}
