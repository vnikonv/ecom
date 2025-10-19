package org.nikon;

import java.util.List;

public class Order {
    private Integer orderId;
    private Customer customer;
    private List<Product> products;
    public Order(Integer id, Customer customer, List<Product> products) {
        this.orderId = id;
        this.customer = customer;
        this.products = products;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
