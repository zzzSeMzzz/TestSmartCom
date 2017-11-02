package ru.sem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sem.exceptions.NotFoundException;
import ru.sem.model.BaseResponse;
import ru.sem.model.User;
import ru.sem.service.UserService;


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
        return "main";
    }


    @RequestMapping(value = "/login.do", method=RequestMethod.GET)
    public String login(){
        return "index";
    }

}
