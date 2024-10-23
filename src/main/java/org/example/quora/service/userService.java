package org.example.quora.service;



import org.example.quora.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public interface userService  {

    public Optional<User> getUserById(UUID id);


    public Optional<User> getUserByEmail(String email);

    public Optional<User> getUserByUsername(String username);
    public Optional<User> getUserByEmailAndPassword(String email, String password);
    public Optional<User> getUserByUsernameAndPassword(String username, String password);

    public Optional<User> createUser(User user);
    public Optional<User> updateUser(User user);
    public Optional<User> deleteUser(UUID id);



}
