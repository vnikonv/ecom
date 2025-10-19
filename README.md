### Objective
The goal of this assignment was to design and develop a simple console-based e-commerce system using Java classes and inheritance. I have practiced object-oriented programming principles such as class design, attributes and methods, encapsulation, and inheritance.

In addition, a part of developing this application included working with a database in sqlite and designing how Java objects are supposed to be stored in a sqlite database, which may not be trivial. The connections between Java objects also had to be turned into connections between SQL table fields with the use of foreign keys.
### Requirement Analysis
The system has two (three) types of users based on user roles: Customer, Employee, and Unassigned. Customer and Employee are children classes of User. Products are divided into categories by child classes inheriting from Product class. An order contains products purchased by a customer.

Users and products can be added to the system through an interactive CLI environment. It also allows listing available users (to employees only) and products (with filtering options). Functionality is available for a registered customer to add/delete products to an order, place the order, cancel an order, and view all orders related to their account.

All classes have appropriate properties, e.g. User(Integer id, String name, String email, String password, Integer balance), Product(Integer id, String name, Integer price, Integer stockQuantity, String category), Order(Integer id, Customer customer, List<Product> products).
Encapsulation is applied by making some attributes protected or private and then providing getters and setters for controlled access.

The program operates from a while loop that runs until a termination condition is met. Collections (ArrayList) store existing users, products, and orders. Scanner is used for input. Menus (e.g., Customer Menu, Employee Menu) are displayed in text form. A sqlite database “econ.db” stores the tables of Users, Products, and Orders.