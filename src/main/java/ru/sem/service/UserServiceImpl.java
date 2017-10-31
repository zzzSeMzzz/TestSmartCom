package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.exceptions.NotFoundException;
import ru.sem.model.User;
import ru.sem.repository.UserRepository;

/**
 * Created by Admin on 30.10.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User get(int id) throws NotFoundException {
        User u = repository.get(id);
        if(u==null) throw  new NotFoundException("Пользователь с таким id не найден");
        else return u;
    }

    @Override
    public User login(User user) throws NotFoundException {
        User u = repository.login(user.getLogin(), user.getPass());
        if(u==null) throw new NotFoundException("Пользователь с таким логином/паролем не найден");
        else return u;
    }
}
