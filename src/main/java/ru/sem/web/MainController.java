package ru.sem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.sem.model.Role;
import ru.sem.service.UserService;

import java.util.Collection;


/**
 * Created by Admin on 27.10.2017.
 */

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger("application");

    @Autowired
    UserService service;


    @RequestMapping(value="/main/", method = RequestMethod.GET)
    public String start(){
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        log.info(authorities.toString());
        //log.info(authorities.stream().findFirst().get().getAuthority());
        log.info("username="+SecurityContextHolder.getContext().getAuthentication().getName());
        if(authorities.stream().findFirst().get().getAuthority()
                .equals(Role.ROLE_MANAGER.name()))
        return "main_manager";
        else return "main_customer";
    }


    @RequestMapping(value = "/login.do", method=RequestMethod.GET)
    public String login(){
        return "index";
    }

}
