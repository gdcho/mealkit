package com.example.mealkit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String email;

    @Builder
    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public void update(String username, String email){
        this.username = username;
        this.email = email;
    }
}
