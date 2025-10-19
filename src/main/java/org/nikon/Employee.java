package org.nikon;

public class Employee extends User {

    public Employee(Integer id, String name, String email, String password, Integer balance) {
        super(id, name, email, password, balance);
        this.role = Role.Employee;
    }
}
