package com.tobioyelami.foodapp.foodapp.restaurant.entities;

import javax.persistence.*;

/**
 * Created by toyelami on 26/01/2019
 */
@Entity(name = "`orders`")
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Customer customer;
    @Column(name = "order_status")
    private Status orderStatus;
    private double cost;
    @Column(name = "is_paid")
    private boolean isPaid;
    @Column(name = "payment_type")
    private PaymentType paymentType;

    enum Status { Making, Cooking, Enroute, Delivered }
    enum PaymentType { Cash, Card }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
