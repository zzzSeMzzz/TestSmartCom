package ru.sem.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.Item;
import ru.sem.model.OrderItem;
import ru.sem.model.Orderm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Admin on 17.11.2017.
 */
@Transactional
@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public OrderItem save(OrderItem orderItem) {
        if(orderItem.isNew()){
            em.persist(orderItem);
            return orderItem;
        }else{
            return em.merge(orderItem);
        }
    }

    @Override
    public OrderItem save(OrderItem orderItem, int itemId, int orderId) {
        orderItem.setOrder(em.getReference(Orderm.class, orderId));
        orderItem.setItem(em.getReference(Item.class, itemId));
        if(orderItem.isNew()){
            em.persist(orderItem);
            return orderItem;
        }else{
            return em.merge(orderItem);
        }
    }

    @Override
    public OrderItem save(OrderItem orderItem, int orderId) {
        orderItem.setOrder(em.getReference(Orderm.class, orderId));
        if(orderItem.isNew()){
            em.persist(orderItem);
            return orderItem;
        }else{
            return em.merge(orderItem);
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
