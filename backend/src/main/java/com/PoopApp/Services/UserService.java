package com.PoopApp.Services;

import com.PoopApp.Entities.User;
import com.PoopApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Register a user into the database and returns the user
     * @param user user to be inserted in database
     * @return the inserted user
     * @throws Exception if another user with same email or nickname already exists
     */
    public User registerUser(User user) throws Exception {

        if (userRepository.findByNickname(user.getNickname()).isPresent() && userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Another user with nickname: " + user.getNickname() + " and with email: " + user.getEmail() + ", already exists.");
        }
        else if (userRepository.findByNickname(user.getNickname()).isPresent()) {
            throw new Exception("Another user with nickname: " + user.getNickname() + ", already exists.");
        }
        else if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new Exception("Another user with email: " + user.getEmail() + ", already exists.");
        }

        return userRepository.save(user);
    }

    /**
     * Find a user given the id
     *
     * @param id id of the user
     * @return the user if exists
     */
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }
}
