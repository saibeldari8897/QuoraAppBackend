package org.example.quora.repositories;

import org.example.quora.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    List<Comments> findAllById(Long id);
}
