import exceptions.NegativeAmountException;
import model.Category;
import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderTest {

    public void setupStange1() throws NegativeAmountException {
        Order order= new Order("Santiago", 2000, LocalDate.now());
        Product product1= new Product("ProductA" , "xxxxA", 1000,  1 ,Category.BOOKS);
        Product product2= new Product("ProductB" , "xxxxB", 1000,  2 , Category.FOOD_AND_DRINKS);
        order.addProductToOrder(product1);
        order.addProductToOrder(product2);
        //Agregar los productos a la lista de order
    }

    @Test
    public void createNewOrderTest() throws NegativeAmountException {
        setupStange1();
        Order order = new Order("Isabella", 2000, LocalDate.now());
        assertEquals("Isabella", order.getNameBuyer());
        assertEquals(2000, order.getTotalPrice(), 0.001);
        assertEquals(LocalDate.now(), order.getDate());
    }




    @Test
    public void addNewProductToOrderTest() throws NegativeAmountException {
        setupStange1();
        Product producto1 = new Product("ProductC", "xxxxA", 2000, 1, Category.FOOD_AND_DRINKS);
        Order order = new Order("Santiago", 2000, LocalDate.now()); // Crear una instancia válida de Order
        order.addProductToOrder(producto1);
        ArrayList<Product> products = order.getProducts();
        assertTrue(products.contains(producto1));
}}
