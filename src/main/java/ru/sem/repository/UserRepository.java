package ru.sem.repository;

import ru.sem.model.User;

/**
 * Created by Admin on 30.10.2017.
 */


public interface UserRepository {

    User get(int id);

    User login(String login, String password);

    User getByName(String name);
}
