package com.dib.Interface;


import com.dib.model.Users;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface UserService {

 public Users addDetails(Users user);

 //registration
 public  List<Users> findUserByUserName(String name);

 public  String deleteUser(int id);
}
