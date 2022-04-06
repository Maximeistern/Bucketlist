package com.example.bucketlistapp.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Email
    private String email;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private Set<ToDo> toDoSet;

    public AppUser(String username, String password, String firstName, String lastName, String email, Set<ToDo> toDoSet) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.toDoSet = toDoSet;
    }

    public AppUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ToDo> getToDoSet() {
        return toDoSet;
    }

    public void setToDoSet(Set<ToDo> toDoSet) {
        this.toDoSet = toDoSet;
    }
}
