package org.example.quora.dtos;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long userId;

    private String title;

    private String body;
}
