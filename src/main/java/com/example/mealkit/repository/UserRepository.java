package com.example.mealkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mealkit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
