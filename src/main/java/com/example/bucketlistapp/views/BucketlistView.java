package com.example.bucketlistapp.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
public class BucketlistView extends VerticalLayout {
    H1 header = new H1("Your Bucketlist Dreams");

    public BucketlistView(){
        setAlignItems(Alignment.CENTER);
        add(header);
    }
}
