package com.dib.Interface;


import com.dib.model.User;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {
 public User registerUser(User user);

 User loginUser(String email, String password);
}
