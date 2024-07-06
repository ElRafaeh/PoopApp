package com.PoopApp.Controllers;

import com.PoopApp.Entities.User;
import com.PoopApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/nickname/{nickname}")
    public Optional<User> getUserByNickName(@PathVariable String nickname) {
        return userService.findByNickname(nickname);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> user(@RequestBody User user) {
        user.setEmail(user.getEmail().toLowerCase());
        user.setNickname(user.getNickname().toLowerCase());

        try {
            User createdUser = userService.registerUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(new User(), HttpStatus.CONFLICT);
        }
    }
}
