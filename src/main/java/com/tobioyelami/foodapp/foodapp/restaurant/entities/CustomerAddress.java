package com.tobioyelami.foodapp.foodapp.restaurant.entities;

/**
 * Created by toyelami on 26/01/2019
 */
public class CustomerAddress {
    private long id;
    private String address;
    private Customer customerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
