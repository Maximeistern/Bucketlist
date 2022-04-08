package com.example.bucketlistapp.repositories;

import com.example.bucketlistapp.enteties.AppUser;
import com.example.bucketlistapp.enteties.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepo extends JpaRepository<ToDo, Integer> {
    List<ToDo> findByAppUser_Username(String username);
}
