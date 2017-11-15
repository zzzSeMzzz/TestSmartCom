package ru.sem.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger("UserRepositoryImpl");


    @PersistenceContext
    private EntityManager em;


    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByName(String name) {
        String q = "SELECT u FROM User u WHERE u.login = :login";
        List<User> users = em.createQuery(q).setParameter("login", name)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.GET_ALL).getResultList();
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(User.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    @Transactional
    public User save(User user) {
        log.info("user isNew() "+user.isNew());
        if(user.isNew()){
            em.persist(user);
            return user;
        }else{
            return em.merge(user);
        }
    }
}
