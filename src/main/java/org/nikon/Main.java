package org.nikon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
* This is the entry point. It should allow a user to log in to their account or create a new account
* Any user may also get information on the products available in stock without an account.
* There are separate action menus for non-logged-in customers, logged-in customers, and employees.
*/

public final class Main {
    public static void main(String[] args) {
        
        boolean run = true; // Termination condition
        boolean logged = false;
        Integer user_id = -1;
        User current_user = null;
        List<User> users = new ArrayList<>();
        users.add(new Employee(1, "admin", "admin", "admin"));
        
        while(run){
            System.out.println("\n--- Welcome to E-commerce Systems LTD! ---\n\n[ PRESS x TO EXIT ]\n\nEnter l to log in.\n" +
                    "Enter c to create a new account.\nEnter u to log out.");
            System.out.println("Logged in: " + logged);
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine(); // This variable is solely used for user input

            switch (answer) {
                case "x" -> run = false;
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
                        case "v" -> System.out.print("View\n");
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
                            "Enter m to view your orders.\nEnter s to open the settings menu.\nEnter r to return to main menu.\n");
                    answer = sc.nextLine();
                    Customer current_customer = (Customer) current_user;
                    switch (answer) {
                        case "v" -> System.out.println("View\n");
                        case "vf" -> System.out.println("Filter\n");
                        case "b" -> System.out.println("Your balance is: " + current_customer.getBalance() + "\n");
                        case "m" -> System.out.println("Orders\n");
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
                    answer = sc.nextLine();
                    Employee current_employee = (Employee) current_user;
                    switch (answer) {
                        case "v" -> System.out.println("View");
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
