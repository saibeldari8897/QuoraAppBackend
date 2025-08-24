package org.example.quora.ServiceImpl;
import org.example.quora.ExceptionHandler.UsernameNotFoundException;
import org.example.quora.dtos.SignInDto;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    @Override
    public String signIn(SignInDto signInDto) {
        Optional<User> user = userRepository.findByEmail(signInDto.getEmail());
        if (user.isEmpty()) {
            throw  new UsernameNotFoundException("user with mail id "+ signInDto.getEmail()+"not found");
        }
        User user1 = user.get();
        if(!passwordEncoder.matches(signInDto.getPassword(), user1.getPassword())) {
            throw new BadCredentialsException("Invalid Password or Email");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user1);
        String token = jwtService.generateToken(customUserDetails);
        return token;
    }
}
