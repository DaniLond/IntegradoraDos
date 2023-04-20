package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String nameBuyer;
    private List<Product> products;
    private Double totalPrice;
    private Date date;

    public Order(String nameBuyer, Double totalPrice, Date date) {
        this.nameBuyer = nameBuyer;
        this.products = new ArrayList<>();
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
