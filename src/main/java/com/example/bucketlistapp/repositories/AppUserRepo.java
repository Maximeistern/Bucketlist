package com.example.bucketlistapp.repositories;

import com.example.bucketlistapp.enteties.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {

    Optional<AppUser> findAppUserByUsername(String username);
}
