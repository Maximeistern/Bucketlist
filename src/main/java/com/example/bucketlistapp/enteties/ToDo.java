package com.example.bucketlistapp.enteties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String dream;

    private boolean done;

    @ManyToOne
    @JoinColumn(name = "appUser_id")
    @NotNull
    private AppUser appUser;

    public ToDo(String dream, AppUser appUser) {
        this.dream = dream;
        this.appUser = appUser;
        this.done = false;
    }

    public ToDo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDream() {
        return dream;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

   public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}


