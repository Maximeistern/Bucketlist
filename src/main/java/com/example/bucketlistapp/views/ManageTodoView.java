package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/managetodo")
public class ManageTodoView extends VerticalLayout {
    Grid<ToDo> grid = new Grid<>(ToDo.class, false);
    public ManageTodoView(ToDoService toDoService){

        grid.setItems(toDoService.findAll());


        grid.addColumn(ToDo::getText).setHeader("Dream");
        grid.addComponentColumn(toDo -> {

            Button editButton = new Button("Edit", evt -> {
                updateList();
            });
            Button deleteButton = new Button("Delete", evt -> {
                toDoService.deleteById(toDo.getId());
                updateList();
            });
            return new HorizontalLayout(editButton,deleteButton);

        });
        /*grid.asSingleSelect().addValueChangeListener(evt -> {
            ToDoForm
        })*/
        add(grid);
    }
    private void updateList() {

    }
}
