package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.BasketItem;
import ru.sem.repository.BasketRepository;
import ru.sem.to.SimpleBasketItem;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<SimpleBasketItem> getMyBasketSimpleItems(int customerId) {
        return getByCustomerId(customerId).stream().map(basketItem -> getSimpleBasketItem(basketItem))
                .collect(Collectors.toList());
    }


    public static SimpleBasketItem getSimpleBasketItem(BasketItem basketItem){
        String itemName="";
        if(basketItem.getItem()!=null) itemName=basketItem.getItem().getName();
        return new SimpleBasketItem(basketItem.getId(), basketItem.getCount(), itemName);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public boolean deleteAllMy(int id_customer) {
        return repository.deleteAllMy(id_customer);
    }
}
