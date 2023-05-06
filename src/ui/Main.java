package ui;

import exceptions.DuplicatedProductException;
import exceptions.NegativeAmountException;
import model.Category;
import model.Controller;

import java.io.IOException;
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

        System.out.println("Welcome to MercadoLibre");

        boolean stopFlag = false;

        while (!stopFlag) {

            System.out.println("\nType an option");
            System.out.println("1. Register product");
            System.out.println("0. Exit");

            int mainOption = reader.nextInt();

            switch (mainOption) {

                case 1:
                    registerProduct();
                    break;
                case 2:

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
}