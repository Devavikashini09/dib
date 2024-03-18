package com.dib.service;
import com.dib.model.Users;
import com.dib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service

public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user=userRepository.findByUsername(name);
        if (user==null){
            throw new UsernameNotFoundException("username not exist");
        }
        List<GrantedAuthority> list=user.getRoles().stream().map(e->new SimpleGrantedAuthority(e.getName())).collect(Collectors.toList());
        return new User(user.getUsername(),user.getPassword(),list);
    }
}
