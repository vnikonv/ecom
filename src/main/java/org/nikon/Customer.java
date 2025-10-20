package org.nikon;

public class Customer extends User {

    private Integer balance;

    public Customer(Integer id, String name, String email, String password, Integer balance) {
        super(id, name, email, password);
        this.role = Role.Customer;
        this.balance = balance;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + "\n" + "Email: " + this.email + "\n" + "Password: " + this.password + "\n" + "Balance: " + this.balance + "\n" + "Role: " + this.role;
    }
}
