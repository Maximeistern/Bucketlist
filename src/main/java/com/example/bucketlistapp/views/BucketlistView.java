package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

import javax.tools.Diagnostic;
import java.awt.*;
import java.util.List;

@Route("")
public class BucketlistView extends VerticalLayout {

    ToDoService todoService;
    H1 header = new H1("Your Bucketlist Dreams");
    ProgressBar progressBar = new ProgressBar();
    Div progressBarLabel = new Div();
    ManageTodoView manageTodoView;
    HorizontalLayout navbarLayout = new HorizontalLayout();
    HorizontalLayout buttonLayout = new HorizontalLayout();

    public BucketlistView(ToDoService toDoService){
        this.todoService = toDoService;
        this.manageTodoView = new ManageTodoView(toDoService);
        setAlignItems(Alignment.CENTER);

        loadNavbar();

        loadProgressbar();

        loadButtonLayout();

        add(navbarLayout, header, progressBarLabel, progressBar, buttonLayout, new Hr());

        todoService.findByAppUser_Username("Maximeistern").forEach(toDo -> {
            H3 title = new H3(toDo.getDream());
            add(title, new Hr());
        });
    }

    private void loadButtonLayout() {
        Button createTodoButton = new Button("New Dream", buttonClickEvent -> {
            Dialog dialog = new Dialog();
            ToDoForm toDoForm = new ToDoForm(todoService, manageTodoView);
            toDoForm.setTodo(new ToDo());
            dialog.add(toDoForm);
            dialog.open();
        });
        Button manageTodoButton = new Button("Manage dreams", buttonClickEvent -> {
            UI.getCurrent().navigate(ManageTodoView.class);
        });
        buttonLayout.add(createTodoButton, manageTodoButton);
    }

    private void loadNavbar() {
        Button logoutButton = new Button("Logout"/*, evt -> PrincipalUtils.logout()*/);
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        navbarLayout.add(logoutButton);
    }

    private void loadProgressbar() {
        List<ToDo> userTodoList = todoService.findByAppUser_Username("Maximeistern");
        progressBarLabel.setText("Dreams fulfilled (/" + userTodoList.toArray().length +")");
        progressBar.setValue(1/userTodoList.toArray().length);
    }


}
