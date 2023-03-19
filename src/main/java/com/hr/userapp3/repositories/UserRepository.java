package com.hr.userapp3.repositories;

import com.hr.userapp3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
