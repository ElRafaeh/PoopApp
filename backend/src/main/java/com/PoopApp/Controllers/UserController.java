package com.PoopApp.Controllers;

import com.PoopApp.Entities.User;
import com.PoopApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getUsers() {
        return "MARICON";
    }

    @GetMapping("/{id}")
    public String getUserById() {
        return "MARICON";
    }

    @PostMapping("/")
    public User user(
            @RequestParam String nickname ,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password
            ) {
        return userRepository.save();
    }
}
