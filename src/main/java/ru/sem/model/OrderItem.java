package ru.sem.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * Created by Admin on 17.11.2017.
 */
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity {

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="order_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Orderm order;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="item_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Item item;

    @Column(name = "items_count")
    private int itemsCount;

    @Column(name = "item_price")
    private int itemPrice;

    public Orderm getOrder() {
        return order;
    }

    public void setOrder(Orderm order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
