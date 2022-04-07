package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/bucketlist")
public class BucketlistView extends VerticalLayout {

    ToDoService toDoService;
    Grid<ToDo> grid = new Grid<>(ToDo.class, false);
    H1 header = new H1("Your Bucketlist Dreams");
    public BucketlistView(ToDoService toDoService){
        this.toDoService = toDoService;
        setAlignItems(Alignment.CENTER);
        Button createTodoButton = new Button("New Dream");
        add(header, createTodoButton);


    }
}
