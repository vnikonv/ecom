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

    public Product(Integer id, String name, Integer price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price + " " + this.stockQuantity + " " + this.category;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Category.valueOf(category);
    }
}
