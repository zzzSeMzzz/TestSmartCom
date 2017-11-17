package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.Customer;
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
                order.getStatus(), order.getOrderNumber(), order.getCustomer().getId());
    }

    @Override
    public Orderm save(Orderm order) {
        return repository.save(order);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Orderm save(SimpleOrder simpleOrder) {
        Orderm order = new Orderm();
        order.setId(simpleOrder.getId());
        order.setOrderDate(simpleOrder.getOrderDate());
        order.setShipmentDate(simpleOrder.getShipmentDate());
        order.setStatus(simpleOrder.getStatus());
        Customer customer = new Customer();
        customer.setId(simpleOrder.getCustomerId());
        order.setCustomer(customer);
        order.setOrderNumber(simpleOrder.getOrderNumber());
        return repository.save(order);
    }
}
