package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Product> products;
    static String path= "data.txt";


    public Inventory() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void save() throws IOException{
        File file= new File(path);
        FileOutputStream fos=new FileOutputStream(file);

        Gson gson= new Gson();
        String data=gson.toJson(products);

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
            Gson gson= new Gson();
            Product[] array= gson.fromJson(content, Product[].class);
            Collections.addAll(products, array);
            fis.close();
        }else {
            file.createNewFile();
        }
    }

}
