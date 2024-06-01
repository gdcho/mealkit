package com.example.mealkit.dto;

import com.example.mealkit.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateUserDto {
    private String username;
    private String email;

    public User toEntity(){
        return User
                .builder()
                .username(username)
                .email(email)
                .build();
    }
}
