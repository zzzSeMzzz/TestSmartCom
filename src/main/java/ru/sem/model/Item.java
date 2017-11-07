package ru.sem.model;

import javax.persistence.*;

/**
 * Created by Admin on 07.11.2017.
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private  int price;

    @Column
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
