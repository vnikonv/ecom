package org.nikon;

public class Clothing extends Product {

    public Clothing(Integer id, String name, Integer price, Integer stockQuantity) {
        super(id, name, price, stockQuantity);
        this.category = Category.valueOf("Clothing");
    }
}
