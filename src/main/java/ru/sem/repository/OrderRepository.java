package ru.sem.repository;

import ru.sem.model.Orderm;

import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */
public interface OrderRepository {

    List<Orderm> getMyOrders(int userId);

    List<Orderm> getAllOrders();

    Orderm save(Orderm order);

    boolean delete(int id);
}
