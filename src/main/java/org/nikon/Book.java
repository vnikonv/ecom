package org.nikon;

public class Book extends Product {

    public Book(Integer id, String name, Integer price, Integer stockQuantity) {
        super(id, name, price, stockQuantity);
        this.category = Category.valueOf("Book");
    }
}
