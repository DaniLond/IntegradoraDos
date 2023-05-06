package model;

import exceptions.NegativeAmountException;

public class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int timesBought;
    private Category category;

    public Product(String name, String description, double price, int quantity, Category category) throws NegativeAmountException {
        if (quantity < 0){
            throw new NegativeAmountException();
        }
        if (price < 0){
            throw new NegativeAmountException();
        }
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.timesBought = 0;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTimesBought() {
        return timesBought;
    }

    public void setTimesBought(int timesBought) {
        this.timesBought = timesBought;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
