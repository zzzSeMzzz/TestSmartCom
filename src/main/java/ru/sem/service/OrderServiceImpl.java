package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.Orderm;
import ru.sem.repository.OrderRepository;
import ru.sem.to.SimpleOrder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 16.11.2017.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public List<Orderm> getMyOrders(int userId) {
        return repository.getMyOrders(userId);
    }

    @Override
    public List<Orderm> getAllOrders() {
        return repository.getAllOrders();
    }

    @Override
    public List<SimpleOrder> getMyOrderSimple(int userId) {
        return getMyOrders(userId).stream().map(order -> convertToSimpleOrder(order))
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleOrder> getAllOrderSimple() {
        return getAllOrders().stream().map(order -> convertToSimpleOrder(order))
                .collect(Collectors.toList());
    }

    public static SimpleOrder convertToSimpleOrder(Orderm order){
        String customerName="";
        if(order.getCustomer()!=null) customerName=order.getCustomer().getName();
        return new SimpleOrder(order.getId(),customerName, order.getOrderDate(), order.getShipmentDate(),
                order.getStatus(), order.getOrderNumber());
    }

    @Override
    public Orderm save(Orderm order) {
        return repository.save(order);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}
