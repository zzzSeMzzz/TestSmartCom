package ru.sem.repository;

import ru.sem.model.OrderItem;

/**
 * Created by Admin on 17.11.2017.
 */
public interface OrderItemRepository {

    OrderItem save(OrderItem orderItem);

    OrderItem save(OrderItem orderItem, int itemId, int orderId);

    OrderItem save(OrderItem orderItem,  int orderId);
}
