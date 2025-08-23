package org.example.quora.ServiceImpl;

import org.example.quora.ExceptionHandler.UserAlreadyExistsException;
import org.example.quora.dtos.SignUpDto;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.SignUpService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection (recommended)
    public SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String signUp(SignUpDto signUpDto) {
        if (userRepository.findByEmail(signUpDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + signUpDto.getEmail() + " already exists");
        }

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword())) // ✅ Encoding password here
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .userName(signUpDto.getUsername())
//                .role("ROLE_USER") // Optional: set default role
                .build();

        userRepository.save(user);

        return "User added successfully";
    }
}
