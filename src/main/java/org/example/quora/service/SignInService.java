package org.example.quora.service;


import org.example.quora.dtos.SignInDto;
import org.springframework.stereotype.Service;

@Service
public interface SignInService {

    public String signIn(SignInDto signInDto);
}
