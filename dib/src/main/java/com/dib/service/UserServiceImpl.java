package com.dib.service;

import com.dib.model.Users;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public  class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users addDetails(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    //registration
    public List<Users> findUserByUserName(String name) {
        Optional<Users> optionalUsers = Optional.ofNullable(userRepository.findByUsername(name));
        if(optionalUsers.isPresent()){
            List<Users> userList = optionalUsers
                    .map(Collections::singletonList) // Converts to List
                    .orElse(Collections.emptyList());
            return userList;}
        else{
            throw new RuntimeException("not found username");
        }
    }

}