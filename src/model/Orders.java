package model;

import com.google.gson.Gson;
import com.sun.deploy.net.MessageHeader;
import exceptions.InvalidDateException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orders {
    private List<Order> orderList;
    private static ArrayList<Order> orders;
    static String path= "data2.txt";
    public Orders() {
        this.orderList= new ArrayList<>();
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {

        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void save() throws IOException {
        File file= new File(path);
        FileOutputStream fos=new FileOutputStream(file);

        Gson gson= new Gson();
        String data=gson.toJson(orders);

        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }

    public void load()throws IOException{
        File file= new File(path);
        if (file.exists()){
            FileInputStream fis= new FileInputStream(file);
            BufferedReader reader= new BufferedReader(new InputStreamReader(fis));

            String content= "";
            String line= "";
            while ( (line= reader.readLine()) != null){
                content += line + "\n";
            }
            if (content.equals("")){
                return;
            }
            Gson gson= new Gson();
            Order[] array= gson.fromJson(content, Order[].class);
            Collections.addAll(orders, array);
            fis.close();
        }else {
            file.createNewFile();
        }
    }

    public List<Order> searchOrderByBuyerName(String buyerName) {
        if (buyerName == null || buyerName.isEmpty()) {
            throw new IllegalArgumentException("you have to enter a valid name");
        }

        Collections.sort(orders, (a, b) -> a.getNameBuyer().compareTo(b.getNameBuyer()));

        int startPoint = 0;
        int endPoint = orders.size() - 1;

        while (startPoint <= endPoint) {
            int midPoint = (startPoint + endPoint) / 2;
            Order order = orders.get(midPoint);

            if (order.getNameBuyer().equals(buyerName)) {
                return Collections.singletonList(order);
            } else if (order.getNameBuyer().compareTo(buyerName) < 0) {
                startPoint = midPoint + 1;
            } else {
                endPoint = midPoint - 1;
            }
        }

        return Collections.emptyList();
    }

    public List<Order> searchOrderByTotalPrice(double totalPrice) {
        if (totalPrice < 0) {
            throw new IllegalArgumentException("The total price cannot be negative");
        }

        List<Order> foundOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order.getTotalPrice() == totalPrice) {
                foundOrders.add(order);
            }
        }

        return foundOrders;
    }

    public List<Order> searchOrderByDate(LocalDate date) {
        List<Order> foundOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order.getDate().equals(date)) {
                foundOrders.add(order);
            }
        }

        return foundOrders;
    }


    public void addOrder(Order order) {
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }



}
