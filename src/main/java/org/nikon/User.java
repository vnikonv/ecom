package org.nikon;

public class User {
    protected Integer id;
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

    public User(Integer id, String name, String email, String password, Integer balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public User() {
        this.id = -1;
        this.name = "None";
        this.email = "None";
        this.password = "None";
        this.balance = 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.email + " " + this.password + " " + this.balance + " " + this.role;
    }
}
