package com.example.bucketlistapp.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("/login"/*, layout = MainLayout.class*/)
@PageTitle("Logga in")
public class LoginView extends Div implements BeforeEnterObserver {


    LoginForm loginForm = new LoginForm();

    public LoginView(){
    addClassName("login-rich-content");
    loginForm.getElement().getThemeList().add("dark");
    add(loginForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")){
            loginForm.setError(true);
        }
    }

}

