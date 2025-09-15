package org.example.quora.ServiceImpl;

import org.example.quora.dtos.QuestionDto;
import org.example.quora.models.Question;
import org.example.quora.models.User;
import org.example.quora.repositories.QuestionRepository;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
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
    public String updateQuestion(QuestionDto questionDto,Long questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        if(question.isPresent()){
            Question question1 = question.get();
            question1.setBody(questionDto.getBody());
            questionRepository.save(question1);
        }else{
            throw new RuntimeException("Question not found");
        }
        return "Question updated successfully";
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
