package org.nikon;

public class Customer extends User {

    private Money balance; // in pennies

    public Customer(Integer id, String name, String email, String password, Integer balance) {
        super(id, name, email, password);
        this.role = Role.Customer;
        this.balance = new Money(balance);
    }

    public void setBalance(Integer balance) {
        this.balance = new Money(balance);
    }

    public Money getBalance() {
        return this.balance;
    }

    public void addBalance(Integer amount) {
        Integer new_balance = this.balance.value + amount;
        setBalance(new_balance);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nEmail: " + this.email + "\nPassword: " + this.password + "\nBalance: " + this.balance.format() + "\nRole: " + this.role;
    }
}
