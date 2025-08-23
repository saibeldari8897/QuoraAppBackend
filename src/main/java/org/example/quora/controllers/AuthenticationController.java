package org.example.quora.controllers;


import org.example.quora.ApiResponses.LoginApiResponse;
import org.example.quora.dtos.SignInDto;
import org.example.quora.dtos.SignUpDto;
import org.example.quora.service.SignInService;
import org.example.quora.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/Auth")
public class AuthenticationController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private SignInService signInService;

    @PostMapping("/signUp")
    public ResponseEntity<LoginApiResponse> signUp(@RequestBody SignUpDto signUpDto) {
        String response = signUpService.signUp(signUpDto);
        LoginApiResponse loginApiResponse = LoginApiResponse.builder()
                .message(response)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(loginApiResponse);
    }


    @PostMapping("/signIn")
    public ResponseEntity<LoginApiResponse> login(@RequestBody SignInDto signInDto) {
        String jwtToken=signInService.signIn( signInDto);
        LoginApiResponse loginApiResponse=LoginApiResponse.builder()
                .status(HttpStatus.OK.value())
                .timestamp(LocalDateTime.now())
                .token(jwtToken)
                .build();
        return ResponseEntity.ok(loginApiResponse);
    }
}
