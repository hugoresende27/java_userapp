package com.hr.userapp3.helpers;

import com.hr.userapp3.models.User;
import com.hr.userapp3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repo.findByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("User not found!");
        }

        return new CustomUserDetails(user);
    }
}
