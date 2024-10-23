package org.example.quora.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.quora.models.User;
import org.example.quora.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements userService{

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public Optional<User> getUserById(UUID id) throws EntityNotFoundException {
        Optional<User> user;
        try {
            user = this.userRepository.findById(id);
            if(user.isEmpty()){
                throw new EntityNotFoundException("User not found with id " + id);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new EntityNotFoundException("User not found with id " + id);
        }
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> user;
        try{
            user=userRepository.findByEmail(email);
            if(user.isEmpty()){
                throw new EntityNotFoundException("User not found with email " + email);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new EntityNotFoundException("User not found with email " + email);
        }
        return user;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        return Optional.empty();
    }

    @Override
    public Optional<User> createUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUser(UUID id) {
        return Optional.empty();
    }
}
