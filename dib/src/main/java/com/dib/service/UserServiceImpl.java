package com.dib.service;
import com.dib.Interface.UserService;
import com.dib.exception.DuplicateNameFound;
import com.dib.exception.NotFoundUser;
import com.dib.model.Users;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public  class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Users addDetails(Users user) {
        Users existingUsers= userRepository.findByUsername(user.getUsername());

        if(existingUsers!=null)
        {
            throw new DuplicateNameFound();
        }

       return userRepository.save(user);
    }//registration
    @Override
    public List<Users> findUserByUserName(String name) {
        Optional<Users> optionalUsers = Optional.ofNullable(userRepository.findByUsername(name));
        if(optionalUsers.isPresent()){
            List<Users> userList = optionalUsers
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
            return userList;}
        else{
            throw new NotFoundUser();
        }
    }
    @Override
    public String deleteUser(int id) {
        Optional<Users> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            Users users = optional.get();
            userRepository.save(users);
            return "User deleted";
        } else {
            throw new NotFoundUser();
        }
    }


}