package ru.sem.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created by Admin on 16.11.2017.
 */

@NamedQueries({

        @NamedQuery(name = BasketItem.GET_ALL_BY_ID,
                query = "SELECT b from BasketItem b where b.id_customer=:id"),

        @NamedQuery(name = BasketItem.GET_BY_ID_FROM_CUSTOMER,
                query = "SELECT b from BasketItem b where b.id_customer=:id AND b.item.id=:item_id"),

        @NamedQuery(name = BasketItem.DELETE, query = "DELETE FROM BasketItem b WHERE b.id=:id")

})

@Entity
@Table(name = "basket")
public class BasketItem extends BaseEntity{

    public static final String GET_ALL_BY_ID = "Basket.GetAllByCustomerId";
    public static final String GET_BY_ID_FROM_CUSTOMER = "Basket.GetByIdFromCustomer";
    public static final String DELETE = "Basket.Delete";

    @Column
    private int id_customer;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_item")
    @NotFound(action = NotFoundAction.IGNORE)
    private Item item;

    @Column
    private int count;

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int incCount(){
        this.count++;
        return count;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "id_customer=" + id_customer +
                ", item=" + item +
                ", count=" + count +
                '}';
    }
}
