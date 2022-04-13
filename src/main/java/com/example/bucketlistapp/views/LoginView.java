package com.example.bucketlistapp.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("/login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginView extends Div implements BeforeEnterObserver {


    LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView(){

        loginOverlay.setTitle("Malin & Max Bucketlist");
        loginOverlay.setDescription("Börja drömma med oss");
        loginOverlay.setOpened(true);
        loginOverlay.setAction("login");

        add(loginOverlay);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")){
            loginOverlay.setError(true);
        }
    }

}

