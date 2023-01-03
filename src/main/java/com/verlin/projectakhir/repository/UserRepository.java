package com.verlin.projectakhir.repository;

import com.verlin.projectakhir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User getUserByLogin(String email, String password);
}
