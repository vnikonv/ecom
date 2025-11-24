package org.nikon.db;

import java.sql.*;

/*
* All database-related logic should be implemented here
*/

public final class Database {

    public static void create_database() {
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:ecom.db");
             Statement stmt = con.createStatement()) {

            // Enable foreign key enforcement
            stmt.execute("PRAGMA foreign_keys = ON");

            // Create users table
            String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY,
                name TEXT,
                email TEXT,
                password TEXT,
                balance INTEGER,
                role TEXT
            );
            """;
            stmt.executeUpdate(sql);

            // Create products table
            sql = """
            CREATE TABLE IF NOT EXISTS products (
                id INTEGER PRIMARY KEY,
                name TEXT,
                price INTEGER,
                stockQuantity INTEGER,
                category TEXT
            );
            """;
            stmt.executeUpdate(sql);

            // Create orders table with foreign key
            sql = """
            CREATE TABLE IF NOT EXISTS orders (
                id INTEGER PRIMARY KEY,
                customerID INTEGER,
                products TEXT,
                FOREIGN KEY (customerID) REFERENCES users(id)
            );
            """;
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void populate_database() {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:ecom.db");
            String sql = "INSERT INTO users(id, name, email, password, balance, role) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "John");
            pstmt.setString(3, "johne@gmail.com");
            pstmt.setString(4, "password");
            pstmt.setInt(5, 100);
            pstmt.setString(6, "Customer");
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void select_table(String name) {
        // Validate table name to contain only letters, digits, or underscores
        if (!name.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException("Invalid table name: " + name);
        }

        String sql = "SELECT * FROM " + name;

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:ecom.db");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
