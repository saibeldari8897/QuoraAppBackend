package org.example.quora.service;


import org.example.quora.dtos.CommentDto;
import org.example.quora.models.Comments;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public interface CommentsService {

    List<Comments> getComments(@PathVariable Long id);

    Comments addComment(CommentDto request);
}
