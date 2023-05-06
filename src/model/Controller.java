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


    public boolean addOrder(String nameBuyer, ArrayList<String> productNames) throws IOException {
        Order order = new Order(nameBuyer);

        for (String productName : productNames) {
            Product product = inventory.searchProduct(productName);
            if (product != null && product.getQuantity() > 0) {
                order.addProduct(product);
                product.setQuantity(product.getQuantity() - 1);
                product.setTimesBought(product.getTimesBought() + 1);
                order.setTotalPrice(order.getTotalPrice() + product.getPrice());
            }
        }

        if (order.getProductArrayList().size() > 0) {
            order.save();
            inventory.save();
            return true;
        } else {
            System.out.println("Some products are not available.");
            return false;
        }
    }

}

