package org.example.quora.controllers;


import org.example.quora.ApiResponses.LoginApiResponse;
import org.example.quora.ExceptionHandler.UserAlreadyExistsException;
import org.example.quora.dtos.UserDtos.UserDto;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.example.quora.service.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final userService userService;
    public UserController(final UserRepository userRepository, final userService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @PostMapping("/adduser")
    public ResponseEntity<LoginApiResponse> addUser(@RequestBody UserDto userDto){
        String message = userService.createUser(userDto);
        LoginApiResponse response = LoginApiResponse.builder().message(message)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CREATED.value())
                .build();
        return new  ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/users/{uuid}")
    public ResponseEntity<User> getUser(@PathVariable Long uuid) {
        Optional<User> user = userService.getUserById(uuid);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{uuid}")
    public ResponseEntity<User> updateUser(@PathVariable Long uuid, @RequestBody UserDto userDto) {
        Optional<User> user = userService.getUserById(uuid);
        if(user.isPresent()) {
            Optional<User> updatedUser = userService.updateUser(uuid,userDto);
            if(updatedUser.isPresent()) {
                return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
