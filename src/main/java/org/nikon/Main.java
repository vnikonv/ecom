package org.nikon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
* This is the entry point. It should allow a user to log in to their account or create a new account.
* There are separate action menus for non-logged-in customers, logged-in customers, and employees.
*/

public final class Main {
    public static void main(String[] args) {

        boolean logged = false;
        Integer user_id = -1;
        User current_user = null;

        List<User> users = new ArrayList<>(); // Implement dumping of list contents into the database and loading contents from the database
        users.add(new Employee(1, "admin", "admin", "admin"));

        List<Product> products = new ArrayList<>();
        products.add(new Book(1, "Hamlet", 150, 3));

        List<Order> orders = new ArrayList<>();

        run:
        while(true){
            System.out.println("\n--- Welcome to E-commerce Systems LTD! ---\n\n[ PRESS x TO EXIT ]\n\nEnter l to log in.\n" +
                    "Enter c to create a new account.\nEnter u to log out.");
            System.out.println("Logged in: " + logged);
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine(); // This variable is solely used for user option input

            switch (answer) {
                case "x" -> {
                    break run;
                }
                case "l" -> {
                    System.out.print("Enter your email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();
                    for (User user : users) {
                        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                            System.out.println("Logged in\n");
                            logged = true;
                            current_user = user;
                            user_id = current_user.getId();
                            
                        } else {
                            System.out.println("Wrong email or password\n");
                        }
                    }
                    System.out.println("Logged in: " + logged + "\n");
                }
                case "c" -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();
                    Integer customer_id = users.size() + 1;
                    Customer customer = new Customer(customer_id, name, email, password, 0);
                    users.add(customer);
                    System.out.println("Account created, return to log in\n");
                    }
                case "u" -> {
                    logged = false;
                    current_user = null;
                    user_id = -1;
                    System.out.println("Logged out\n");
                }
            }
            
            if (user_id == -1) {
                while (!answer.equals("r")) {
                    System.out.println("--- CUSTOMER MENU (NOT LOGGED IN) ---");
                    System.out.println("Enter v to view products.\nEnter vf to view products with a filter.\nEnter r to return to main menu.\n");
                    answer = sc.nextLine();
                    switch (answer) {
                        case "v" -> {
                            products.forEach(System.out::println);
                        }
                        case "vf" -> System.out.println("Filter\n");
                        case "r" -> {
                        }
                        default -> System.out.println("Invalid input.\n");
                    }
                }
            } else if (Objects.equals(current_user.getRole(), "Customer")) {
                while (!answer.equals("r")) {
                    System.out.println("--- CUSTOMER MENU ---");
                    System.out.println("Enter v to view products.\nEnter vf to view products with a filter.\nEnter b to check your balance.\n" +
                            "Enter o to create a new order.\nEnter m to view your orders.\nEnter s to open the settings menu." +
                            "\nEnter q to add money to the account.\nEnter r to return to main menu.\n");
                    answer = sc.nextLine();
                    Customer current_customer = (Customer) current_user;
                    switch (answer) {
                        case "v" -> {
                            products.forEach(System.out::println);
                        }
                        case "vf" -> System.out.println("Filter\n");
                        case "b" -> System.out.println("Your balance is: " + current_customer.getBalance().format() + "\n");
                        case "o" -> {
                            /*
                            List<Integer> order_ids = new ArrayList<>();
                            while (!answer.equals("n")) {
                                System.out.println("Enter the product id: ");
                                Integer product_id = sc.nextInt();
                                products.stream().filter(product -> Objects.equals(product.getId(), product_id)).forEach();
                                if () {
                                    if
                                } else {
                                    System.out.println("A product with that ID does not exist\n");
                                }
                                order_ids.add(product_id);
                                System.out.println("Create the order? (y/n)");
                                answer = sc.nextLine();
                            }
                             */
                            Integer order_id = orders.size() + 1;
                            int calculate_total = products.stream()
                                    .filter(product -> product.getId() == 1)
                                    .mapToInt(price -> price.getPrice().value)
                                    .sum();
                            orders.add(new Order(order_id, current_customer, products, calculate_total));
                            current_customer.addBalance(-calculate_total);
                            System.out.println("Orders created:\n");
                            orders.stream()
                                    .filter(order -> Objects.equals(order.getId(), order_id))
                                    .forEach(System.out::println);
                            System.out.println();
                        }
                        case "m" -> {
                            System.out.print("Your orders:\n");
                            orders.stream()
                                    .filter(order -> Objects.equals(order.getCustomer().getId(), current_customer.getId()))
                                    .forEach(System.out::println);
                            System.out.println();
                        }
                        case "s" -> {
                            System.out.println("\n --- SETTINGS ---");
                            System.out.println("Enter n to change name.\nEnter e to change email.\nEnter p to change password.\nEnter b to go back.");
                            answer = sc.nextLine();
                            switch (answer) {
                                case "n" -> {
                                    System.out.print("Enter new name: ");
                                    answer =  sc.nextLine();
                                    current_customer.setName(answer);
                                    System.out.println("Changed name: " + current_customer.getName() + "\n");
                                }
                                case "e" -> {
                                    System.out.print("Enter new email: ");
                                    answer =  sc.nextLine();
                                    current_customer.setEmail(answer);
                                    System.out.println("Changed email: " + current_customer.getEmail() + "\n");
                                }
                                case "p" -> {
                                    System.out.print("Enter new password: ");
                                    answer =  sc.nextLine();
                                    current_customer.setPassword(answer);
                                    System.out.println("Changed password: " + current_customer.getPassword() + "\n");
                                }
                                case "b" -> {
                                }
                            };
                        }
                        case "q" -> {
                            System.out.println("Enter the amount to deposit: ");
                            Integer amount = Integer.valueOf(sc.nextLine());
                            current_customer.addBalance(amount);
                            System.out.println("New balance: " + current_customer.getBalance() + "\n");
                        }
                        case "r" -> {
                        }
                        default -> System.out.println("Invalid input.");
                    }
                }
            } else if (Objects.equals(current_user.getRole(), "Employee")) {
                while (!answer.equals("r")) {
                    System.out.println("\n--- EMPLOYEE MENU ---");
                    System.out.println("Enter v to view products.\nEnter vf to view products with a filter.\nEnter c to view all customer accounts.\n" +
                            "Enter s to open the settings menu.\nEnter r to return to main menu.\n");
                    // Note to self: allow employees to create new products
                    answer = sc.nextLine();
                    Employee current_employee = (Employee) current_user;
                    switch (answer) {
                        case "v" -> {
                            products.forEach(System.out::println);
                        }
                        case "vf" -> System.out.println("Filter");
                        case "c" -> {
                            for (User user : users) {
                                if (user.getRole().equals("Customer")) {
                                    Customer this_customer = (Customer) user;
                                    System.out.print(this_customer + "\n\n");
                                }
                            }
                        }
                        case "s" -> {
                            System.out.println("\n --- SETTINGS ---");
                            System.out.println("Enter n to change name.\nEnter e to change email.\nEnter p to change password." +
                                    "\nEnter b to go back.");
                            answer = sc.nextLine();
                            switch (answer) {
                                case "n" -> {
                                    System.out.print("Enter new name: ");
                                    answer =  sc.nextLine();
                                    current_employee.setName(answer);
                                    System.out.println("Changed name: " + current_employee.getName() + "\n");
                                }
                                case "e" -> {
                                    System.out.print("Enter new email: ");
                                    answer =  sc.nextLine();
                                    current_employee.setEmail(answer);
                                    System.out.println("Changed email: " + current_employee.getEmail() + "\n");
                                }
                                case "p" -> {
                                    System.out.print("Enter new password: ");
                                    answer =  sc.nextLine();
                                    current_employee.setPassword(answer);
                                    System.out.println("Changed password: " + current_employee.getPassword() + "\n");
                                }
                                case "b" -> {
                                }
                            };
                        }
                        case "r" -> {
                        }
                        default -> System.out.println("Invalid input.");
                    }
                }
            }

        }
    }
}
