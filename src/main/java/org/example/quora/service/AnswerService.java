package org.example.quora.service;

import org.example.quora.repositories.AnswerRepository;
import org.springframework.boot.CommandLineRunner;

public class AnswerService implements CommandLineRunner {


    private AnswerRepository answerRepository;
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
