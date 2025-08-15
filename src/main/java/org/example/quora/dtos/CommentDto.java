package org.example.quora.dtos;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String text;
    private Long parentId;
    private Long userId;
    private Long answerId;
}
