package com.example.filmback.service;

import com.example.filmback.DTO.LoginDto;
import com.example.filmback.entity.User;
import com.example.filmback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    LoginDto loginDto;

    public void addUser(User user){
        this.userRepository.save(user);
    }

    public User getUser(String username,String password){
        return this.userRepository.findUserByUsernameAndPassword(username,password);
    }

    public User getUserByUsername(String username){
        return this.userRepository.findUserByUsername(username);

    }
    public User login(LoginDto loginDto){
        return  this.getUser(loginDto.getUsername(),loginDto.getPassword());
    }

}
