package com.example.bucketlistapp.security;

import com.example.bucketlistapp.enteties.AppUser;
import com.example.bucketlistapp.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {

    @Autowired
    AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appuser = appUserRepo.findAppUserByUsername(username).orElseThrow();
        return new User(appuser.getUsername(), appuser.getPassword(), List.of());
    }
}
