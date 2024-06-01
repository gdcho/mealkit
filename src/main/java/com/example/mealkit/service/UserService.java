package com.example.mealkit.service;

import com.example.mealkit.dto.CreateUserDto;
import com.example.mealkit.dto.UpdateUserDto;
import com.example.mealkit.model.User;
import com.example.mealkit.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(CreateUserDto request) {
        return userRepository.save(request.toEntity());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User update(long id, UpdateUserDto request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found:" + id));

        user.update(request.getUsername(), request.getEmail());

        return user;
    }
}
