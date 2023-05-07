package ui;

import exceptions.*;
import model.Category;
import model.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Scanner reader;
    public Controller controller;

    public Main() throws IOException {
        this.reader = new Scanner(System.in);
        this.controller= new Controller();
        controller.load();
    }

    public static void main(String[] args) throws IOException{
        Main manager= new Main();
        manager.showMainMenu();
    }

    public void showMainMenu() {

        System.out.println("-----------MENU-------------");

        System.out.println("Welcome to MercadoLibre");

        boolean stopFlag = false;

        while (!stopFlag) {

            System.out.println("Type an option");
            System.out.println("1. Register product");
            System.out.println("2. Register order");
            System.out.println("3. Search for a product");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();

            switch (mainOption) {

                case 1:
                    registerProduct();
                    break;
                case 2:
                    registerOrder();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 0:
                    System.out.println("Thanks for using our system");
                    stopFlag = true;
                    break;
                default:
                    System.out.println("You must type a valid option");
                    break;

            }

        }

    }

    public void registerProduct() {
        try{
            System.out.println("Enter the name");
            reader.nextLine();
            String name= reader.nextLine();
            System.out.println("Enter the description");
            String description= reader.nextLine();
            System.out.println("Enter the price");
            double price= reader.nextDouble();
            System.out.println("Enter the quantity");
            int quantity= reader.nextInt();
            System.out.println("Choose a category");
            System.out.println(controller.toStringCategory());
            int category= reader.nextInt();
            if (controller.addProductToInvetory(name, description, price, quantity, Category.values()[category])){
                System.out.println("Product registered successfully");
            }
        }catch (NegativeAmountException e){
            System.out.println(e.getMessage());
            e.getStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        } catch (DuplicatedProductException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

    }

    public void registerOrder() {
        try {
            System.out.println("Enter the buyer's name:");
            reader.nextLine();
            String nameBuyer = reader.nextLine();
            System.out.println("Enter the number of products:");
            int numProducts = reader.nextInt();
            ArrayList<String> productNames = new ArrayList<>();
            System.out.println("Enter the names of the products:");
            reader.nextLine();
            for (int i = 0; i < numProducts; i++) {
                String productName = reader.nextLine();
                productNames.add(productName);
            }
            if (controller.addOrder(nameBuyer, productNames)) {
                System.out.println("Order registered successfully");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public void searchProduct() {
        try {
            System.out.println("By which variable you want to seatch for a product");
            System.out.println("0. Name \n1. Price\n2. Category\n3. number of shares");
            int option = reader.nextInt();
            reader.nextLine();
            if (option == 2){
                System.out.println("These are the categories that exist");
                System.out.println(controller.toStringCategory());
            }
            System.out.println("Write the value");
            String value = reader.nextLine();
            System.out.println(controller.searchProduct(value, option));
        } catch (NonexistentIndexException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        } catch (NonexistentCategoryException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

}