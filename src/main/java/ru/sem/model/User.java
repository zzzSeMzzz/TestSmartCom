package ru.sem.model;


/**
 * Created by Admin on 27.10.2017.
 */
public class User extends BaseEntity{


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
