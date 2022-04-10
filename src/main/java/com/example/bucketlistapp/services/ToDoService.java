package com.example.bucketlistapp.services;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.repositories.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    ToDoRepo toDoRepo;

    public List<ToDo> findAll(){
        return toDoRepo.findAll();
    }

    public List<ToDo> findByAppUser_Username(String username){
        return toDoRepo.findByAppUser_Username(username);
    }

    public ToDo createToDo(ToDo toDo){
        return toDoRepo.save(toDo);
    }

    public void deleteById(int id){
        toDoRepo.deleteById(id);
    }

    public ToDo updateById(int id, ToDo newToDo){
        ToDo oldToDo = toDoRepo.findById(id).orElseThrow();

        oldToDo.setDream(newToDo.getDream());

        return toDoRepo.save(oldToDo);
    }
}
