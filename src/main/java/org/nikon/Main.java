package org.nikon;

import java.util.Scanner;

import static org.nikon.Database.database;

/*
* This is the entry point. It should allow a user to sign in to their account or create a new account.
* Any user may also get information on the products available in stock without an account.
*/

public final class Main {
    public static void main(String[] args) {
        boolean run = true;
        database();
        while(run){
            System.out.println("\nWelcome to E-commerce Systems LTD!\n\n[ PRESS x TO EXIT ]\n\nSign in? (y/n)");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("x")){
                run = false;
            }
            else if(input.equals("y")){
                System.out.print("Enter your email: ");
                String email = sc.nextLine();
                System.out.print("Enter your password: ");
                String password = sc.nextLine();

            }
        }
    }
}
