package org.nikon;

public class Customer extends User {

    public Customer(String name, String email, String password, Integer balance) {
        super(name, email, password, balance);
        this.role = Role.Customer;
    }
}
