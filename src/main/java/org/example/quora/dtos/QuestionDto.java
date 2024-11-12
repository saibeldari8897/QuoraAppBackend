package org.example.quora.dtos;


import lombok.*;
import org.example.quora.models.User;

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
