package org.nikon;

public class Customer extends User {

    public Customer(Integer id, String name, String email, String password, Integer balance) {
        super(id, name, email, password, balance);
        this.role = Role.Customer;
    }
}
