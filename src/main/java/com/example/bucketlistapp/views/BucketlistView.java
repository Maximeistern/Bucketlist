package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.security.PrincipalUtils;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.security.PermitAll;
import javax.tools.Diagnostic;
import java.awt.*;
import java.util.List;

@CssImport("./Styles/styles.css")
@Route("")
@PageTitle("BucketlistDreams || Dreams")
@PermitAll
public class BucketlistView extends VerticalLayout {

    ToDoService todoService;
    PrincipalUtils principalUtils;
    H1 header = new H1("Your Bucketlist Dreams");
    ProgressBar progressBar = new ProgressBar();
    Div progressBarLabel = new Div();
    ManageTodoView manageTodoView;
    HorizontalLayout navbarLayout = new HorizontalLayout();
    HorizontalLayout buttonLayout = new HorizontalLayout();

    public BucketlistView(ToDoService toDoService, PrincipalUtils principalUtils){
        this.principalUtils = principalUtils;
        this.todoService = toDoService;
        this.manageTodoView = new ManageTodoView(toDoService);

        setAlignItems(Alignment.CENTER);

        loadNavbar();

        loadProgressbar();

        loadButtonLayout();

        add(navbarLayout, header, progressBarLabel, progressBar, buttonLayout, new Hr());

        renderDreams();
    }

    private void renderDreams(){
        todoService.findByAppUser_Username(PrincipalUtils.getName()).forEach(toDo -> {
            VerticalLayout dreams = new VerticalLayout();
            dreams.setAlignItems(Alignment.CENTER);
            H2 title = new H2(toDo.getDream());

            dreams.add(title, new Hr());
            dreams.addClassName("dreamCard");
            dreams.addClickListener(evt -> {
                toDo.setDone(!toDo.isDone());
                todoService.setDone(toDo);
                updateDream();
            });
            add(dreams);
        });
    }

    private void updateDream() {
        this.getChildren().filter(x -> x.getElement().getClassList().contains("dreamCard"))
                .forEach(this::remove);
        loadProgressbar();
        renderDreams();
    }

    private void loadButtonLayout() {
        Button createDreamButton = new Button("New Dream", buttonClickEvent -> {
            Dialog dialog = new Dialog();
            ToDoForm toDoForm = new ToDoForm(todoService, manageTodoView);
            ToDo toDo = new ToDo();
            toDo.setAppUser(principalUtils.getAppuserPrincipalUtils());
            toDoForm.setTodo(toDo);
            dialog.add(toDoForm);
            dialog.setModal(false);
            dialog.setDraggable(true);
            dialog.open();
        });
        Button manageDreamButton = new Button("Manage dreams", buttonClickEvent -> {
            UI.getCurrent().navigate(ManageTodoView.class);
        });
        buttonLayout.add(createDreamButton, manageDreamButton);
    }

    private void loadNavbar() {
        Button logoutButton = new Button("Logout", new Icon(VaadinIcon.EXIT), evt -> PrincipalUtils.logout());
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Image logo = new Image("./src/main/java/com/example/bucketlistapp/views/BucketlistView.java", "Logo");
        navbarLayout.addClassName("navbarLayout");
        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        navbarLayout.add(logo, logoutButton);
    }

    private void loadProgressbar() {
        List<ToDo> userTodoList = todoService.findByAppUser_Username(PrincipalUtils.getName());
        List<ToDo> checkedTodoList = userTodoList.stream().filter(ToDo::isDone).toList();
        progressBarLabel.setText("Dreams fulfilled ("+ checkedTodoList.toArray().length +"/" + userTodoList.toArray().length +")");
        progressBar.setValue((double) checkedTodoList.toArray().length/userTodoList.toArray().length);
        if(progressBar.getValue()==1){
            progressBarLabel.setText("Fulfilled all of your dreams");
        }
    }

}
