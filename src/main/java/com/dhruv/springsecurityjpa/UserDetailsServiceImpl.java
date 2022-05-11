package com.dhruv.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userD = userRepo.findByUserName(username);
        userD.orElseThrow(() -> new UsernameNotFoundException("User name not found with user: " + username));
        UserDetailsImpl userDetails = new UserDetailsImpl(userD.get());
        return userDetails;
    }
}
