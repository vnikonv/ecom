package org.nikon;

public class Product {
    protected Integer id;
    protected String name;
    protected Integer price;
    protected Integer stockQuantity;

    public enum Category {
        Book,
        Electronics,
        Clothing
    }

    protected Category category;

    public Product(Integer id, String name, Integer price, Integer stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = Category.valueOf(category);
    }

    @Override
    public String toString() {
        return this.name + " " + this.price + " " + this.stockQuantity + " " + this.category;
    }
}
