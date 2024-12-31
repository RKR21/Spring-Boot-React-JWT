package com.project.jwt.Controllers;

import com.project.jwt.Models.User;
import com.project.jwt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Error: Email already in use!";
        }

        userRepository.save(user);
        return "User registered successfully!";
    }
}
