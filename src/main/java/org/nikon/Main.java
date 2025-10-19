package org.nikon;

import java.util.Scanner;
import org.nikon.Database;

/*
* This is the entry point. It should allow a user to sign in to their account or create a new account
* Any user may also get information on the products available in stock without an account.
*/

public final class Main {
    public static void main(String[] args) {
        boolean run = true; // Termination condition
        Database.create_database();
        Database.select_table("users");
        while(run){
            System.out.println("\nWelcome to E-commerce Systems LTD!\n\n[ PRESS x TO EXIT ]\n\nSign in? (y/n)");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine(); // This variable is solely used for user input

            switch (answer) {
                case "x" -> run = false;
                case "y" -> {
                    System.out.print("Enter your email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();
                    System.out.println("Logged in\n");
                }
                case "n" -> {
                    System.out.println("Create an account? (y/n)");
                    answer = sc.nextLine();
                    switch (answer) {
                        case "y" -> {
                            System.out.print("Enter your email: ");
                            String email = sc.nextLine();
                            System.out.print("Enter your password: ");
                            String password = sc.nextLine();
                            System.out.println("Account created\n");
                        }
                        case "n" -> {
                            System.out.println("\n! Without an account, you can view products, but cannot add them to an order.\n");
                        }
                        default -> System.out.println("Invalid input.");
                    }
                }
                default -> System.out.println("Invalid input.");
            }

            System.out.println("--- CUSTOMER MENU ---");
            System.out.println("Enter v to view products.\nEnter vf to view products with a filter.\nEnter m to see your orders.\nEnter r to return to main menu.\n.");
            answer = sc.nextLine();
            switch (answer) {
                case "v" -> System.out.print("View");
                case "vf" -> System.out.println("Filter");
                case "m" -> System.out.print("User's Orders");
                case "r" -> {
                    continue;
                }
                default -> System.out.println("Invalid input.");
            }

        }
    }
}
