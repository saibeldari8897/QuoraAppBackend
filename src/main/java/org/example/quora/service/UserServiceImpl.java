package org.example.quora.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.quora.dtos.UserDtos.UserDto;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements userService{

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {

        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return Optional.of(user);
    }

    @Override
    public Optional<User> updateUser(UUID id, UserDto userDto) {

        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        return Optional.of(userRepository.save(user));
    }


}
