package org.example.quora.dtos;

import lombok.*;

import java.util.Date;

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
