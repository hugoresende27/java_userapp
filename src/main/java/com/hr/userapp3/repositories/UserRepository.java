package com.hr.userapp3.repositories;

import com.hr.userapp3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u where u.email = ?1")
    User findByEmail(String email);
}
