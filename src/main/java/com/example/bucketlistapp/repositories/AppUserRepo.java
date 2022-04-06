package com.example.bucketlistapp.repositories;

import com.example.bucketlistapp.enteties.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
}
