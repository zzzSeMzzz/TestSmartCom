package ru.sem.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.exceptions.NotFoundException;
import ru.sem.model.Customer;
import ru.sem.model.Role;
import ru.sem.model.User;
import ru.sem.repository.UserRepository;
import ru.sem.to.UserAdv;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 30.10.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger("UserServiceImpl");

    @Autowired
    UserRepository repository;

    @Override
    public User get(int id) throws NotFoundException {
        User u = repository.get(id);
        if(u==null) throw  new NotFoundException("Пользователь с таким id не найден");
        else return u;
    }

    /*@Override
    public User login(User user) throws NotFoundException {
        User u = repository.login(user.getLogin(), user.getPass());
        if(u==null) throw new NotFoundException("Пользователь с таким логином/паролем не найден");
        else return u;
    }*/

    @Override
    public User getDataByUserName(String name) {
        return repository.getByName(name);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public UserAdv save(UserAdv userAdv) {
        User user = new User();
        if(userAdv.getIdCustomer()!=null) {
            Customer customer = new Customer();
            customer.setId(userAdv.getIdCustomer());
            user.setCustomer(customer);
        }
        user.setRole(Role.values()[userAdv.getIdRole()]);
        user.setLogin(userAdv.getLogin());
        user.setPass(userAdv.getPassword());
        user.setId(userAdv.getId());
        log.info("save user "+user.toString());
        repository.save(user);
        return userAdv;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public List<UserAdv> getAllUserWithCustomerName() {
        List<User> users = getAll();
        log.info("user count="+users.size());
        return  users.stream().map(user -> createUserAdv(user)).collect(Collectors.toList());
    }

    public static UserAdv createUserAdv(User user){
        Customer customer = user.getCustomer();
        Integer cId = customer == null ? null : customer.getId();
        String cName = customer == null ? null : customer.getName();
        return new UserAdv(user.getId(), cId, cName, user.getRole().ordinal(), user.getLogin(),
                user.getPass(), user.getRole().name());
    }
}
