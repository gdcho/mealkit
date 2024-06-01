package com.example.mealkit.controller;

import com.example.mealkit.dto.UserDto;
import com.example.mealkit.dto.CreateUserDto;
import com.example.mealkit.dto.UpdateUserDto;
import com.example.mealkit.model.User;
import com.example.mealkit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody CreateUserDto request){
        User savedUser = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/api/user")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        List<UserDto> users = userService.findAll()
                .stream()
                .map(UserDto::new)
                .toList();

        return ResponseEntity.ok()
                .body(users);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody UpdateUserDto request){
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedUser);
    }
}
