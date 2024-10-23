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
    public Optional<Question> getQuestionById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsByAuthor(String author) {
        return List.of();
    }

    @Override
    public Question createQuestion(QuestionDto questionDto, UUID userId) {

        try {
            User user = userRepository.findById(userId).get();
            Question question = new Question();
            question.setTitle(questionDto.getTitle());
            question.setBody(questionDto.getBody());
            question.setCreatedAt(new Date());
            question.setUser(user);
            return questionRepository.save(question);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(int id) {

    }

    @Override
    public void deleteQuestionByAuthor(String author) {

    }

    @Override
    public void deleteQuestionByQuestionId(int id) {

    }
}
