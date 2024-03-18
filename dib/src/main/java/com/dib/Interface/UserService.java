package com.dib.Interface;


import com.dib.model.Users;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {
 public Users registerUser(Users user);

 Users loginUser(String username, String password);
}
