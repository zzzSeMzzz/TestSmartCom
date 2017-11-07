package ru.sem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sem.model.Item;
import ru.sem.repository.ItemRepository;

import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> getAll() {
        return repository.getAll();
    }
}
