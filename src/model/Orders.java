package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Orders {
    private static ArrayList<Order> orders;
    static String path= "data2.txt";
    public Orders() {
        this.orders = new ArrayList<>();
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





}
