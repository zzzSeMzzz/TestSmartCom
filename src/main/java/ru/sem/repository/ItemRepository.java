package ru.sem.repository;

import ru.sem.model.Item;

import java.util.List;

/**
 * Created by Admin on 07.11.2017.
 */
public interface ItemRepository {

    List<Item> getAll();

    Item save(Item item);

    boolean delete(int id);
}
