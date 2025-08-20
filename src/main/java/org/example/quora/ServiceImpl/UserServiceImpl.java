package org.example.quora.ServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.quora.ExceptionHandler.UserAlreadyExistsException;
import org.example.quora.dtos.UserDtos.UserDto;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.userService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements userService {

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDto userDto) throws UserAlreadyExistsException {
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + userDto.getEmail() + " already exists");
        }
        User user = User.builder()
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .build();
        userRepository.save(user);

        return "User added successfully";
    }

    @Override
    public Optional<User> getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return Optional.of(user);
    }

    @Override
    public Optional<User> updateUser(Long id, UserDto userDto) {

        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        return Optional.of(userRepository.save(user));
    }


}
