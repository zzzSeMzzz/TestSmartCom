package ru.sem.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getAll() {
        return em.createNamedQuery(Customer.GET_ALL_SORTED).getResultList();
    }

    @Override
    public Customer save(Customer item) {
        if(item.isNew()){
            em.persist(item);
            return item;
        }else{
            return em.merge(item);
        }
    }

    @Override
    public boolean delete(int id) {
        return em.createNamedQuery(Customer.DELETE).setParameter("id", id).executeUpdate() !=0;
    }
}
