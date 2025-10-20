package org.nikon;

public class Product {
    protected Integer id;
    protected String name;
    protected Money price; // In pennies
    protected Integer stockQuantity;

    public enum Category {
        Book,
        Electronics,
        Clothing,
        Undefined
    }

    protected Category category = Category.valueOf("Undefined");

    public Product(Integer id, String name, Integer price, Integer stockQuantity, String category) {
        this.id = id;
        this.name = name;
        this.price = new Money(price);
        this.stockQuantity = stockQuantity;
        this.category = Category.valueOf(category);
    }

    public Product(Integer id, String name, Integer price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = new Money(price);
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nPrice: " + this.price.format() + "\nStock Quantity: " + this.stockQuantity + "\nCategory: " + this.category + "\n";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = new Money(price);
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getCategory() {
        return this.category.name();
    }

    public void setCategory(String category) {
        this.category = Category.valueOf(category);
    }
}
