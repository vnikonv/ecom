package org.nikon;

public class Employee extends User {

    public Employee(String name, String email, String password, Integer balance) {
        super(name, email, password, balance);
        this.role = Role.Employee;
    }
}
