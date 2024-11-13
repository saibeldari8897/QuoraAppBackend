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
    private UUID answerId;
    private UUID questionId;
    private UUID userId;
    private String text;
    private Date createdAt;
}
