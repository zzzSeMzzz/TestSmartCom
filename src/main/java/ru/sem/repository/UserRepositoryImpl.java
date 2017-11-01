package ru.sem.repository;


import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 30.10.2017.
 */

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {


    @PersistenceContext
    private EntityManager em;


    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User login(String login, String password) {
        String q = "SELECT u FROM User u WHERE u.login = :login AND u.pass = :password";
        List<User> users = em.createQuery(q).setParameter("login", login)
                .setParameter("password", password).getResultList();
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public User getByName(String name) {
        String q = "SELECT u FROM User u WHERE u.login = :login";
        List<User> users = em.createQuery(q).setParameter("login", name)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }
}
