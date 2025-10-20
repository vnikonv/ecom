package org.nikon;

public class Money { // pennies by default
    public Integer value;

    public Money(Integer value) {
        this.value = value;
    }

    public String format() {
        return String.format("%d.%02d$", this.value / 100, this.value % 100);
    }

    @Override
    public String toString() {
        return this.format();
    }
}
