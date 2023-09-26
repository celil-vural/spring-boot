package com.example.springmongorestapi2.api;
import com.example.springmongorestapi2.entity.User;
import com.example.springmongorestapi2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserRepository userRepository;

    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}