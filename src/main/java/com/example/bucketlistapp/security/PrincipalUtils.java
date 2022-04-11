package com.example.bucketlistapp.security;

import com.example.bucketlistapp.enteties.AppUser;
import com.example.bucketlistapp.repositories.AppUserRepo;
import com.example.bucketlistapp.views.LoginView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class PrincipalUtils {

    @Autowired
    AppUserRepo appUserRepo;

    public AppUser getAppuserPrincipalUtils(){
        return appUserRepo.findAppUserByUsername(getName()).orElseThrow();
    }

    public static String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isAuthenticated(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equalsIgnoreCase("anonymousUser");
    }

    public static void logout(){
        new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
        UI.getCurrent().navigate(LoginView.class);
    }
}
