package ru.sem.to;

import ru.sem.model.OrderStatus;

import java.util.Date;

/**
 * Created by Admin on 16.11.2017.
 */
public class SimpleOrder {

    private int id;

    private String customerName;

    private int customerId;

    private Date orderDate;

    private Date shipmentDate;

    private OrderStatus status;

    private int orderNumber;

    public SimpleOrder() {
    }

    public SimpleOrder(int id, String customerName, Date orderDate, Date shipmentDate, OrderStatus status,
                       int orderNumber, int customerId) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.status = status;
        this.orderNumber=orderNumber;
        this.shipmentDate=shipmentDate;
        this.customerId=customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
