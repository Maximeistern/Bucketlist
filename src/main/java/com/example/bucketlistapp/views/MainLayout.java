package com.example.bucketlistapp.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/*@CssImport("./styles/styles.css")*/
@Route("")
public class MainLayout extends VerticalLayout {


    public MainLayout(){
        createNavbar();
        createHerosection();
    }

    private void createNavbar() {
        HorizontalLayout navbarLayout = new HorizontalLayout();
        navbarLayout.add();

        H1 header = new H1("Main navbar");
    }


    private void createHerosection(){

        H1 header = new H1("Main herosection");

    }

}
