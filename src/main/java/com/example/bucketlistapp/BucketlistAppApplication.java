package com.example.bucketlistapp;

import com.example.bucketlistapp.enteties.AppUser;
import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.repositories.AppUserRepo;
import com.example.bucketlistapp.repositories.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BucketlistAppApplication implements CommandLineRunner {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    ToDoRepo todoRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BucketlistAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        AppUser Max = new AppUser("Maximeistern", passwordEncoder.encode("max"), "Max", "Stolpe", "maxstolpe@mail.com");
        AppUser Malin = new AppUser("MalinOnBucketlistDreams", passwordEncoder.encode("malin"),"Malin", "Eriksson", "malineriksson@mail.com");
        appUserRepo.saveAll(List.of(
                Max, Malin
        ));

        ToDo toDo = new ToDo("Gå på toan", Max);
        ToDo toDo1 = new ToDo("Surfa", Max);
        ToDo toDo2 = new ToDo("Begå brott", Max);
        ToDo toDo3 = new ToDo("Dricka mig full i Las Vegas", Malin);
        ToDo toDo4 = new ToDo("Skaffa barn med en kändis", Malin);
        ToDo toDo5 = new ToDo("Spela tennis med Donald Trump", Malin);
        todoRepo.saveAll(List.of(
                toDo, toDo1, toDo2, toDo3, toDo4, toDo5
        ));
    }
}
