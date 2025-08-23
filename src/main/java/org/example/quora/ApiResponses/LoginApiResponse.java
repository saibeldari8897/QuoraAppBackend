package org.example.quora.ApiResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginApiResponse {

    private String message;
    private LocalDateTime timestamp;
    private int status;
    private String token;
}
