package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.security.PrincipalUtils;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route("/managetodo")
@PermitAll
public class ManageTodoView extends VerticalLayout {
    Grid<ToDo> grid = new Grid<>(ToDo.class, false);
    ToDoService toDoService;
    ToDoForm toDoForm;
    public ManageTodoView(ToDoService toDoService){
        this.toDoService = toDoService;
        toDoForm = new ToDoForm(toDoService, this);
        //setAlignItems(Alignment.CENTER);
        Button backButton = new Button("Back to dreams", evt -> {
            UI.getCurrent().navigate(BucketlistView.class);
        });


        grid.setItems(toDoService.findByAppUser_Username(PrincipalUtils.getName()));

        grid.addColumn(ToDo::getDream).setHeader("Dream");

        grid.addComponentColumn(toDo -> {
            Button editButton = new Button(new Icon(VaadinIcon.PENCIL),evt -> {
                Dialog dialog = new Dialog();
                ToDoForm toDoForm = new ToDoForm(toDoService, this);
                toDoForm.setTodo(toDo);
                dialog.add(toDoForm);
                dialog.open();
                updateItem();
            });
            Button deleteButton = new Button(new Icon(VaadinIcon.CLOSE_SMALL), evt -> {
                toDoService.deleteById(toDo.getId());
                updateItem();
            });
            return new HorizontalLayout(editButton,deleteButton);

        });
        add(backButton, grid);
    }
    private void updateList() {

    }

    public void updateItem() {
        grid.setItems(toDoService.findByAppUser_Username(PrincipalUtils.getName()));
    }
}
