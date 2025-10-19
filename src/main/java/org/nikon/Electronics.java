package org.nikon;

public class Electronics extends Product {

    public Electronics(Integer id, String name, Integer price, Integer stockQuantity) {
        super(id, name, price, stockQuantity);
        this.category = Category.valueOf("Electronics");
    }
}
