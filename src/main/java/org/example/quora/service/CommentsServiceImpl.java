package org.example.quora.service;


import jakarta.transaction.Transactional;
import org.example.quora.dtos.CommentDto;
import org.example.quora.models.Answer;
import org.example.quora.models.Comments;
import org.example.quora.models.User;
import org.example.quora.repositories.AnswerRepository;
import org.example.quora.repositories.CommentRepository;
import org.example.quora.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public List<Comments> getComments(UUID id) {
        List<Comments> comments = commentRepository.findAllById(id);
        return comments;
    }

    @Override
    @Transactional
    public Comments addComment(CommentDto request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Answer answer = answerRepository.findById(request.getAnswerId())
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        Comments comment = Comments.builder()
                .text(request.getText())
                .parentId(request.getParentId())
                .CreatedAt(new Date())
                .user(user)
                .build();

        // Save comment first (to generate ID)
        Comments savedComment = commentRepository.save(comment);

        // Initialize comments list if null
        if (answer.getComments() == null) {
            answer.setComments(new ArrayList<>());
        }

        // Add comment to answer's comment list
        answer.getComments().add(savedComment);

        // Save answer to update join table
        answerRepository.save(answer);

        return savedComment;
    }

}
