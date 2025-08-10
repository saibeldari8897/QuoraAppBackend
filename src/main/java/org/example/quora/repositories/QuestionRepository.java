package org.example.quora.repositories;

import org.example.quora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findByUserId(UUID userId);
}
