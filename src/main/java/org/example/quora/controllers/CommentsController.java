package org.example.quora.controllers;


import org.example.quora.dtos.CommentDto;
import org.example.quora.models.Answer;
import org.example.quora.models.Comments;
import org.example.quora.models.User;
import org.example.quora.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/getComments{id}")
    public ResponseEntity<List<Comments>> getComments(@PathVariable UUID id) {
        List<Comments> list =commentsService.getComments(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    };

    @PostMapping("/postComment")
    public ResponseEntity<Comments> postComment(@RequestBody CommentDto request) {
        Comments savedComment = commentsService.addComment(request);
        return ResponseEntity.ok(savedComment);
    }
}
