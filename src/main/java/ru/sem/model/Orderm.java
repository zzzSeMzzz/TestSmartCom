package ru.sem.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;


@NamedQueries({

        @NamedQuery(name = Orderm.GET_ALL_BY_USER,
                query = "SELECT o from Orderm o where o.customer.id=:id"),

        @NamedQuery(name = Orderm.GET_ALL,
                query = "SELECT o FROM Orderm o"),

        @NamedQuery(name = Orderm.DELETE, query = "DELETE FROM Orderm o WHERE o.id=:id")

})

/**
 * Created by Admin on 16.11.2017.
 */
@Entity
@Table(name = "orders")
public class Orderm extends BaseEntity {

    public static final String GET_ALL_BY_USER = "GetAllByCurrentUser";
    public static final String GET_ALL= "GetAll";
    public static final String DELETE= "DeleteById";

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Customer customer;


    @Column
    private int order_number;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;


    @Column(name = "shipment_date")
    @Temporal(TemporalType.DATE)
    private Date shipmentDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public int getOrderNumber() {
        return order_number;
    }

    public void setOrderNumber(int orderNumber) {
        this.order_number = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
