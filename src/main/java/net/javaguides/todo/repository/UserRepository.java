package net.javaguides.todo.repository;

import net.javaguides.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//import org.springframework.security.core.userdetails.User;



public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}
