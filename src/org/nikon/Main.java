package org.nikon;
import java.util.ArrayList;
import java.util.List;

/*
Objective:
The goal of this assignment is to design and develop a simple console-based e-commerce system using Java classes and inheritance.
Students will practice object-oriented programming principles such as class design, attributes and methods, encapsulation, and inheritance.

Requirements
The system must allow:

Managing Users (e.g., Customer, Employee).
Managing Products (e.g., Book, Electronics, Clothing).
Managing Orders (an order contains products purchased by a customer).
Handling basic operations like:
Adding products and users to the system.
Listing available users and products.
Customers placing an order. Viewing all orders.
Each object must have appropriate attributes and methods. Examples:

User: name, email, password, role (customer/employee).
Product: id, name, price, stockQuantity, displayInfo().
Order: orderId, customer, list of products, totalAmount, printReceipt().
Apply inheritance:

User class → extended by Customer and Employee.
Product class → extended by Book, Electronics, Clothing.
Apply encapsulation:

All attributes must be private.
Provide getters and setters for controlled access.
Use collections (ArrayList) to store users, products, and orders.

Interact with the user via the console:

Use Scanner for input.
Display menus (e.g., Customer Menu, Employee Menu,).
Let users choose actions such as list products, add product, place order, view orders, etc.
*/

public class Main {
    public static void main(String[] args) {
        Customer name = new Customer("Name", "email", "password", 123);
        Customer john = new Customer("John", "email", "password", 123);
        List<Customer> customers = new ArrayList<>();
        customers.add(name);
        customers.add(john);
        System.out.println(name);
        System.out.println(name.getRole());
        System.out.println(customers);

        Employee john1 = new Employee("John", "email", "password", 123);
        Employee john2 = new Employee("John", "email", "password", 123);
        List<Employee> employees = new ArrayList<>();
        employees.add(john1);
        employees.add(john2);
        System.out.println(john1.getRole());
        System.out.println(employees);

        Product stuff = new Product(1, "stuff", 12, 1, "Book");
        System.out.println(stuff);
    }
}
