package com.example.filmback.repository;

import com.example.filmback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
    public User findUserByUsernameAndPassword(String username,String password);
}
