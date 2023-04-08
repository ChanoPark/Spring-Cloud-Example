package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserResponse;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final Environment env;
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public ResponseEntity<String> status() {
        return ResponseEntity.ok().body(greeting.getMessage());
//        return ResponseEntity.ok().body(env.getProperty("greeting.message"));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody RequestUser requestUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(new UserDto(requestUser)));
    }

}
