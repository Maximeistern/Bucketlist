package com.example.bucketlistapp.views;

import com.example.bucketlistapp.enteties.ToDo;
import com.example.bucketlistapp.services.ToDoService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.awt.*;

public class ToDoForm extends FormLayout {
/*
    TextField dream = new TextField("Dream");
    Button saveButton = new Button("Save");

    Binder<ToDo> binder = new BeanValidationBinder<>(ToDo.class);
    ToDoService toDoService;

    public ToDoForm(ToDoService toDoService, ManageTodoView manageTodoView){
        this.toDoService = toDoService;
        setVisible(false);
        binder.bindInstanceFields(this);

        saveButton.addClickListener(evt -> onSave());

        add(dream, saveButton);
    }

    private void onSave() {
        ToDo toDo = binder.validate().getBinder().getBean();
        if(toDo.getId() != 0){
            toDoService.updateById(toDo.getId(), toDo);
        }else {
            toDoService.createToDo(toDo);
        }
        setTodo(null);
    }

    void setTodo(ToDo todo) {
        if(todo != null){
            binder.setBean(todo);
            setVisible(true);
        }else{
            setVisible(false);
        }
    }*/
}
