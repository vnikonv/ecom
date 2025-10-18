package org.nikon;

public class User {
    // Should have the following properties: name, email, password, role (customer or employee),
    // and balance
    protected String name;
    protected String email;
    protected String password;

    public enum Role {
        Customer,
        Employee,
        Unassigned
    }

    protected Role role = Role.Unassigned;

    public Role getRole() {
        return this.role;
    }

    protected Integer balance;

    public User(String name, String email, String password, Integer balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return this.name + " " + this.email + " " + this.password + " " + this.balance + " " + this.role;
    }
}
