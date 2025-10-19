package org.nikon;

import java.util.List;

public class Order {
    Integer orderId;
    Customer customer;
    List<Product> products;
    public Order(Integer orderId, Customer customer, List<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }
}
