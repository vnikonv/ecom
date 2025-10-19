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

    public void setRole(String role) {
        this.role = Role.valueOf(role);
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
