package ru.sem.repository;

import ru.sem.model.Customer;

import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
public interface CustomerRepository {

    List<Customer> getAll();

    Customer save(Customer item);

    boolean delete(int id);
}
