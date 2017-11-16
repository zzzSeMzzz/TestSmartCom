package ru.sem.to;

/**
 * Created by Admin on 16.11.2017.
 */

/*
Упрощенная модель для просомтра своей корзины
 */
public class SimpleBasketItem {

    private String itemName;

    private int id;

    private int count;

    public SimpleBasketItem() {
    }

    public SimpleBasketItem(int id, int count, String itemName) {
        this.id = id;
        this.count = count;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
