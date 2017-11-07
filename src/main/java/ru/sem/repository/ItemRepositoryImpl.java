package ru.sem.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.Item;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */

@Repository
@Transactional(readOnly = true)
public class ItemRepositoryImpl implements ItemRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> getAll() {
        return em.createQuery("SELECT i FROM Item i").getResultList();
    }

    @Override
    @Transactional
    public Item save(Item item) {
        if(item.isNew()){
            em.persist(item);
            return item;
        }else{
            return em.merge(item);
        }
    }
}
