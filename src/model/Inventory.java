package model;

import com.google.gson.Gson;
import exceptions.DuplicatedProductException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        if (searchProductByName(product.getName()) == -1){
            products.add(product);
            save();
            return true;
        }else {
            throw new DuplicatedProductException();
        }
    }

    public int searchProductByName(String name){
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
                return puntoMedio;
            }else if (value.getName().compareTo(name) < 0){
                inicio = puntoMedio + 1;
            }else {
                fin= puntoMedio - 1;
            }

        }
        return -1;
    }

    public int searchProductByPrice(double price){
        Collections.sort(products,  (a, b) -> {
            return Double.compare(a.getPrice(), b.getPrice());
        });

        int puntoMedio=0;
        int inicio= 0;
        int fin= products.size()-1;
        while (inicio <= fin){
            puntoMedio= (inicio + fin)/2;
            Product value= products.get(puntoMedio);
            if (value.getPrice() == price){
                return puntoMedio;
            }else if (value.getPrice() < price){
                inicio = puntoMedio + 1;
            }else {
                fin= puntoMedio - 1;
            }

        }
        return -1;
    }

    public int searchProductByCategory(Category category){
        Collections.sort(products, (a , b)->{
            return Integer.compare(a.getValueCategory(), b.getValueCategory());
        });
        int puntoMedio=0;
        int inicio= 0;
        int fin= products.size()-1;
        while (inicio <= fin){
            puntoMedio= (inicio + fin)/2;
            Product value= products.get(puntoMedio);
            if (value.getCategory() == category){
                return puntoMedio;
            }else if (value.valueCategory() < category.valueCategory(category)){
                inicio = puntoMedio + 1;
            }else {
                fin= puntoMedio - 1;
            }

        }
        return -1;
    }

    public int searchProductByTimeBought(int timeBought){
        Collections.sort(products, (a , b)->{
            return Integer.compare(a.getTimesBought(), b.getTimesBought());
        });
        int puntoMedio=0;
        int inicio= 0;
        int fin= products.size()-1;
        while (inicio <= fin){
            puntoMedio= (inicio + fin)/2;
            Product value= products.get(puntoMedio);
            if (value.getTimesBought() == timeBought){
                return puntoMedio;
            }else if (value.getTimesBought() < timeBought){
                inicio = puntoMedio + 1;
            }else {
                fin= puntoMedio - 1;
            }

        }
        return -1;
    }

    public ArrayList<Product> searchProductByValue(String value, int option){
        ArrayList<Product> list;
        if (option == 0){
            int indiceProduct= searchProductByName(value);
            list= new ArrayList<>();
            list.add(products.get(indiceProduct));
            return list;
        } else if (option == 1) {
            double priceD= Double.parseDouble(value);
            int start= searchProductByPrice(priceD);
            if (start == -1){
                list= new ArrayList<>();
                return list;
            }
            // Encontrar el índice del último producto con el precio buscado
            int end= start;
            while (Double.compare(products.get(start).getPrice(), priceD) == 0 && start >= 0){
                start--;
            }

            while (end < products.size() && Double.compare(products.get(end).getPrice(), priceD) == 0){
                end++;
            }
            list= new ArrayList<>(products.subList(start+1 , end));
            return list;
        } else if (option == 2) {
            Category category= Category.values()[Integer.parseInt(value)];
            int start= searchProductByCategory(category);
            if (start == -1){
                list= new ArrayList<>();
                return list;
            }
            int end= start;
            while (Integer.compare(products.get(start).getValueCategory(), category.valueCategory(category)) == 0 && start >= 0){
                start--;
            }
            while (end < products.size() && Integer.compare(products.get(end).getValueCategory(), category.valueCategory(category)) == 0){
                end++;
            }
            list= new ArrayList<>(products.subList(start+1 , end));
            return list;
        } else if (option == 3) {
            int timesBought= Integer.parseInt(value);
            int start= searchProductByTimeBought(timesBought);
            if (start == -1){
                list= new ArrayList<>();
                return list;
            }
            int end= start;
            while (Integer.compare(products.get(start).getTimesBought(), timesBought) == 0 && start >= 0){
                start--;
            }

            while (end < products.size() && Integer.compare(products.get(end).getTimesBought(), timesBought) == 0){
                end++;
            }
            list= new ArrayList<>(products.subList(start+1 , end));
            return list;
        }
        list= new ArrayList<>();
        return list;
    }

}
