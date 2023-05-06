package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String nameBuyer;
    private ArrayList<Product> productArrayList;
    private double totalPrice;
    private LocalDate date;

    public Order(String nameBuyer) {
        this.nameBuyer = nameBuyer;
        productArrayList= new ArrayList<>();
        this.date= LocalDate.now();
        totalPrice=0;
    }

    public Order(String nameBuyer, double totalPrice, LocalDate date) {
        this.nameBuyer = nameBuyer;
        this.productArrayList = new ArrayList<>();
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void addProduct(Product product) {
    }

    public void save() {
    }
}
