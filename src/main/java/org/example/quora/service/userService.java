package org.example.quora.service;



import org.example.quora.dtos.UserDtos.UserDto;
import org.example.quora.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public interface userService  {

    public User createUser(UserDto userDto);

    public Optional<User> getUserById(UUID id);

    public Optional<User> updateUser(UUID id, UserDto userDto);

}
