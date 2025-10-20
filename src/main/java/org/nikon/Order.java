package org.nikon;

import java.util.List;

public class Order {

    private final Integer id;
    private final Customer customer;
    private final List<Product> products;
    private final Money totalPrice;

    public Order(Integer id, Customer customer, List<Product> products, Integer totalPrice) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.totalPrice = new Money(totalPrice);
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order ID: " + this.id + "\nCustomer Name: " + this.customer.getName() + "\nProducts included:" + this.products +
        "\nTotal: " + this.totalPrice;
    }
}
