package org.example.quora.service;



import org.example.quora.ExceptionHandler.UserAlreadyExistsException;
import org.example.quora.dtos.UserDtos.UserDto;
import org.example.quora.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public interface userService  {

    public String createUser(UserDto userDto) throws UserAlreadyExistsException;

    public Optional<User> getUserById(Long id);

    public Optional<User> updateUser(Long id, UserDto userDto);

}
