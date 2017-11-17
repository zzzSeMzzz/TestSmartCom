package ru.sem.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.Orderm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */
@Transactional
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private static final Logger log = LoggerFactory.getLogger("OrderRepositoryImpl");

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Orderm> getMyOrders(int userId) {
        return em.createNamedQuery(Orderm.GET_ALL_BY_USER)
                .setParameter("id", userId).getResultList();
    }

    @Override
    public List<Orderm> getAllOrders() {
        return em.createNamedQuery(Orderm.GET_ALL).getResultList();
    }

    @Override
    public Orderm save(Orderm order) {
        if(order.isNew()){
            log.info("is new order");
            em.persist(order);
            return order;
        }else{
            return em.merge(order);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Orderm.DELETE)
                .setParameter("id", id).executeUpdate() != 0;
    }
}
