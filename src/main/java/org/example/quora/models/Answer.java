package org.example.quora.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @JsonBackReference
    private Question question;

    @Column(name = "answer_text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> comments = new ArrayList<>();
}
