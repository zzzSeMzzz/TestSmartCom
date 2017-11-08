package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.Customer;
import ru.sem.repository.CustomerRepository;

import java.util.List;

/**
 * Created by Admin on 08.11.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer save(Customer item) {
        return repository.save(item);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}
