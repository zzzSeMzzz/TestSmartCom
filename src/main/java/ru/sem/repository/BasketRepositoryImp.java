package ru.sem.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sem.model.BasketItem;
import ru.sem.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */

@Repository
@Transactional
public class BasketRepositoryImp implements BasketRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<BasketItem> getByCustomerId(int id) {
        return em.createNamedQuery(BasketItem.GET_ALL_BY_ID).setParameter("id", id)
                .getResultList();
    }

    @Override
    public BasketItem getItemByCustomerId(int customer_id, int item_id) {
        List<BasketItem> basketItemList =
        em.createNamedQuery(BasketItem.GET_BY_ID_FROM_CUSTOMER)
                .setParameter("id", customer_id)
                .setParameter("item_id", item_id)
                .getResultList();
        return DataAccessUtils.singleResult(basketItemList);
    }

    @Override
    public BasketItem addItemToCustomer(int customer_id, int item_id) {
        BasketItem basketItem = getItemByCustomerId(customer_id, item_id);
        if(basketItem==null){
            //если еще нет такого товара в корзине
            basketItem = new BasketItem();
            basketItem.setId_customer(customer_id);
            Item item = new Item();
            item.setId(item_id);
            basketItem.setItem(item);
            basketItem.setCount(1);
            em.persist(basketItem);
            return basketItem;
        }else{
            basketItem.incCount();
            return em.merge(basketItem);
        }
    }
}
