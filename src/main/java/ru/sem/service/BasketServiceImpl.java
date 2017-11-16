package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.BasketItem;
import ru.sem.repository.BasketRepository;

import java.util.List;

/**
 * Created by Admin on 16.11.2017.
 */

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketRepository repository;

    @Override
    public List<BasketItem> getByCustomerId(int id) {
        return repository.getByCustomerId(id);
    }

    @Override
    public BasketItem getItemByCustomerId(int customer_id, int item_id) {
        return repository.getItemByCustomerId(customer_id, item_id);
    }

    @Override
    public BasketItem addItemToCustomer(int customer_id, int item_id) {
        return repository.addItemToCustomer(customer_id, item_id);
    }
}
