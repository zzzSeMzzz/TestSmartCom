package ru.sem.service;

import ru.sem.exceptions.NotFoundException;
import ru.sem.model.User;
import ru.sem.to.UserAdv;

import java.util.List;

/**
 * Created by Admin on 30.10.2017.
 */
public interface UserService {

    User get(int id) throws NotFoundException;

    User getDataByUserName(String name);

    List<User> getAll();

    boolean delete(int id);

    User save(User user);

    UserAdv save(UserAdv userAdv);

    List<UserAdv> getAllUserWithCustomerName();
}
