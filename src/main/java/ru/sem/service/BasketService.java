package ru.sem.service;

import ru.sem.model.BasketItem;
import ru.sem.to.SimpleBasketItem;

import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */
public interface BasketService {

    List<BasketItem> getByCustomerId(int id);

    List<SimpleBasketItem> getMyBasketSimpleItems(int customerId);

    BasketItem getItemByCustomerId(int customer_id, int item_id);

    BasketItem addItemToCustomer(int customer_id, int item_id);

    boolean delete(int id);

    boolean deleteAllMy(int id_customer);
}
