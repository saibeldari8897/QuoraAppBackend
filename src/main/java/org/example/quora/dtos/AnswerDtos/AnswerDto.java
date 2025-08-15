package org.example.quora.dtos.AnswerDtos;

import lombok.*;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Long answerId;
    private Long questionId;
    private Long userId;
    private String text;
    private Date createdAt;
}
