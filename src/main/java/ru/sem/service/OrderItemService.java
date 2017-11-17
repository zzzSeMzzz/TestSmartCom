package ru.sem.service;

import ru.sem.model.BasketItem;
import ru.sem.model.OrderItem;
import ru.sem.to.SimpleOrder;

/**
 * Created by Admin on 17.11.2017.
 */
public interface OrderItemService {

    OrderItem createFromBasketItem(BasketItem basketItem, int orderId);

    OrderItem save(OrderItem orderItem);
}
