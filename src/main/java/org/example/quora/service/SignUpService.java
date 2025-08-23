package org.example.quora.service;


import org.example.quora.dtos.SignUpDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface SignUpService {

    public String signUp(@RequestBody SignUpDto signUpDto);
}
