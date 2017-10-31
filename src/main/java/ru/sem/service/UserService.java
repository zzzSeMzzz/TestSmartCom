package ru.sem.service;

import ru.sem.exceptions.NotFoundException;
import ru.sem.model.User;

/**
 * Created by Admin on 30.10.2017.
 */
public interface UserService {

    User get(int id) throws NotFoundException;

    User get(String login, String password) throws NotFoundException;
}