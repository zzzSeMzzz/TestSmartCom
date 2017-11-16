package ru.sem.service;

import ru.sem.model.BasketItem;

import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */
public interface BasketService {

    List<BasketItem> getByCustomerId(int id);

    BasketItem getItemByCustomerId(int customer_id, int item_id);

    BasketItem addItemToCustomer(int customer_id, int item_id);
}
