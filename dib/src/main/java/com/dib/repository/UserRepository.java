package com.dib.repository;
import com.dib.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    public Users findByUsername(String name);


}
