package model;

import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private Orders order;
    private Inventory inventory;

    public Controller() {
        this.order = new Orders();
        this.inventory = new Inventory();
    }

    public void load() throws IOException {
        order.load();
        inventory.load();
    }

    public boolean addProductToInvetory(String name, String description, double price, int quantity, Category category) throws NegativeAmountException, DuplicatedProductException, IOException {
        Product product= new Product(name,description, price, quantity, category);
        inventory.addProduct(product);
        return true;
    }

    public String toStringCategory() {
        Category typeCategory[] = Category.values();
        String catString = "Category";
        for (int i = 0; i < typeCategory.length; i++) {
            catString += "\n" + i + ")" + typeCategory[i];
        }
        return catString;
    }
}
