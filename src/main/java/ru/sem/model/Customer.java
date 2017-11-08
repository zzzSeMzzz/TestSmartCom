package ru.sem.model;

import javax.persistence.*;

/**
 * Created by Admin on 07.11.2017.
 */

@NamedQueries({

        @NamedQuery(name = Customer.GET_ALL_SORTED,
                query = "SELECT c FROM Customer c"),
        @NamedQuery(name = Customer.DELETE,
                query = "DELETE FROM Customer c WHERE c.id=:id"),

})

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

    public static final String GET_ALL_SORTED = "Customer.getAll";
    public static final String DELETE = "Customer.delete";


    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String code;

    @Column
    private Integer discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                '}';
    }
}
