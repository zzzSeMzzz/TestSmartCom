package ru.sem.service;

import ru.sem.model.Orderm;
import ru.sem.to.SimpleOrder;

import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */
public interface OrderService {

    List<Orderm> getMyOrders(int userId);

    List<Orderm> getAllOrders();

    List<SimpleOrder> getMyOrderSimple(int userId);

    List<SimpleOrder> getAllOrderSimple();

    Orderm save(Orderm order);

    boolean delete(int id);
}
