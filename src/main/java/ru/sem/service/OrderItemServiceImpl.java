package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.BasketItem;
import ru.sem.model.OrderItem;
import ru.sem.repository.OrderItemRepository;

/**
 * Created by Admin on 17.11.2017.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepository repository;

    @Override
    public OrderItem createFromBasketItem(BasketItem basketItem, int orderId) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItemsCount(basketItem.getCount());
        orderItem.setItem(basketItem.getItem());
        orderItem.setItemPrice(basketItem.getItem().getPrice());
        return repository.save(orderItem, orderId);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return repository.save(orderItem);
    }
}
