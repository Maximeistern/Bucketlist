package com.example.bucketlistapp.repositories;

import com.example.bucketlistapp.enteties.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDo, Integer> {
}
