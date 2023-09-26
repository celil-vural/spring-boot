package com.example.springelasticsearch.api;


import com.example.springelasticsearch.entity.User;
import com.example.springelasticsearch.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    @PostConstruct
    public void init(){
        User user =new User();
        user.setName("Celil");
        user.setSurname("Vural");
        user.setAddress("test");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("000000");
        userRepository.save(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok((List<User>) userRepository.findAll());
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> searchUsers(@PathVariable String search) {
        return ResponseEntity.ok(userRepository.findByNameLikeOrSurnameLike(search,search));
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}
