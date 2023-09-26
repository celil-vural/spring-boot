package com.example.springbootresttemplate.api;

import com.example.springbootresttemplate.model.User;
import com.example.springbootresttemplate.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class RestClientController {

    private static final String webUri="http://localhost:8081/api/users";
    private final RestTemplate restTemplate;
    @GetMapping
    public ResponseEntity<List<UserDto>> getUserList(){
        ResponseEntity<List<UserDto>> result = restTemplate.exchange(
                webUri, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDto>>() {});
        List<UserDto> response=result.getBody();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        ResponseEntity<UserDto> result=restTemplate.postForEntity(webUri, userDto,UserDto.class);
        UserDto response=result.getBody();
        return ResponseEntity.ok(response);
    }
}
