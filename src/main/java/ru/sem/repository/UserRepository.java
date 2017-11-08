package ru.sem.repository;

import ru.sem.model.Item;
import ru.sem.model.User;

import java.util.List;

/**
 * Created by Admin on 30.10.2017.
 */


public interface UserRepository {

    User get(int id);

    User getByName(String name);

    List<User> getAll();

    boolean delete(int id);

    User save(User user);
}
