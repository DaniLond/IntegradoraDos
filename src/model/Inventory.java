package model;

import com.google.gson.Gson;
import exceptions.DuplicatedProductException;

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

    public int getSize(){
        return products.size();
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
            if (content.equals("")){
                return;
            }
            Gson gson= new Gson();
            Product[] array= gson.fromJson(content, Product[].class);
            Collections.addAll(products, array);
            fis.close();
        }else {
            file.createNewFile();
        }
    }

    public boolean addProduct(Product product) throws DuplicatedProductException, IOException {

        if (searchProduct(product.getName()) == null){
            products.add(product);
            save();
            return true;
        }else {
            throw new DuplicatedProductException();
        }
    }

    public Product searchProduct(String name){
        Collections.sort(products, (a , b)->{
            return a.getName().compareTo(b.getName());
        });
        int puntoMedio=0;
        int inicio= 0;
        int fin= products.size()-1;
        while (inicio <= fin){
            puntoMedio= (inicio + fin)/2;
            Product value= products.get(puntoMedio);
            if (value.getName().equals(name)){
                return value;
            }else if (value.getName().compareTo(name) < 0){
                inicio = puntoMedio + 1;
            }else {
                fin= puntoMedio - 1;
            }

        }
        return null;
    }

}
