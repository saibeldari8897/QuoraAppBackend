package org.example.quora.dtos.QuestionDtos;


import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private UUID userId;

    private String title;

    private String body;
}
