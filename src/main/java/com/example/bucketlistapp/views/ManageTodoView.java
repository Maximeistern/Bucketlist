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
    ToDoService toDoService;
    ToDoForm toDoForm;
    public ManageTodoView(ToDoService toDoService){
        this.toDoService = toDoService;
        toDoForm = new ToDoForm(toDoService, this);
        grid.setItems(toDoService.findByAppUser_Username("Maximeistern"));


        grid.addColumn(ToDo::getDream).setHeader("Dream");
        grid.addComponentColumn(toDo -> {

            Button editButton = new Button("Edit", evt -> {
                grid.asSingleSelect().addValueChangeListener(ev -> {
                    toDoForm.setTodo(ev.getValue());
                });
                updateList();
            });
            Button deleteButton = new Button("Delete", evt -> {
                toDoService.deleteById(toDo.getId());
                updateItem();
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

    public void updateItem() {
        grid.setItems(toDoService.findAll());
    }
}
