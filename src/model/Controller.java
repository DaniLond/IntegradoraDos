package model;

import exceptions.*;

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
        Order order1 = new Order(nameBuyer);
        for (String productName : productNames) {
            int indice = inventory.searchProductByName(productName);
            Product product = inventory.getProducts().get(indice);
            if (product != null && product.getQuantity() > 0) {
                order1.addProduct(product);
                System.out.println(order1.getProductArrayList().get(0).getName());
                product.setQuantity(product.getQuantity() - 1);
                product.setTimesBought(product.getTimesBought() + 1);
                order1.setTotalPrice(order1.getTotalPrice() + product.getPrice());
            }
        }
            order.getOrders().add(order1);
            order.save();
            inventory.save();
            return true;
    }


    public String searchProduct(String value, int option) throws NonexistentIndexException, NonexistentCategoryException, EmptyListException {
        ArrayList<Product> products = inventory.searchProductByValue(value, option);
        String product= "";
        for (int i=0; i < products.size(); i++){
            product += products.get(i).getName() +" - " + products.get(i).getPrice() + " - " + products.get(i).getQuantity() + " - " + products.get(i).getCategory() +" - " +  products.get(i).getTimesBought() + "\n";
        }
        if (product.equals("")){
            return "There ir no product with this value";
        }
        return product;
    }

    public boolean removeProductFromInventory(String productName) throws IOException {
        for (Product product : inventory.getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                inventory.getProducts().remove(product);
                order.save();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> getInventory() {
        return inventory.getProducts();
    }

    public void increaseProductQuantity(String productName, int quantityToAdd) throws NegativeAmountException, IOException {
        if (quantityToAdd < 0) {
            throw new NegativeAmountException("Quantity to add cannot be negative");
        }
        for (Product product : inventory.getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                int newQuantity = product.getQuantity() + quantityToAdd;
                product.setQuantity(newQuantity);

                inventory.save();

                return;
            }
        }
    }

}

