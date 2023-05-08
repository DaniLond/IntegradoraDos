import exceptions.NegativeAmountException;
import model.Category;
import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    public void setupStange1() throws NegativeAmountException {
        Order order= new Order("Santiago", 2000, LocalDate.now());
        Product product1= new Product("ProductA" , "xxxxA", 1000,  1 ,Category.BOOKS);
        Product product2= new Product("ProductB" , "xxxxB", 1000,  2 , Category.FOOD_AND_DRINKS);
        order.addProductToOrder(product1);
        order.addProductToOrder(product2);
        //Agregar los productos a la lista de order
    }
    public void setupStange2(List<Order> orderList){
        Order order= new Order("Santiago", 2000, LocalDate.now());
        Order order1= new Order("Valentian", 3000, LocalDate.now());
        orderList.add(order);
        orderList.add(order1);

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
}
    @Test
    public void addOrder(){
        List<Order> orderList = new ArrayList<>();
        setupStange2(orderList);
        // Verificar que se hayan agregado las órdenes correctamente
        assertEquals(2, orderList.size());
        assertEquals("Santiago", orderList.get(0).getNameBuyer());
        assertEquals(2000, orderList.get(0).getTotalPrice());
        assertEquals(LocalDate.now(), orderList.get(0).getDate());
        assertEquals("Valentian", orderList.get(1).getNameBuyer());
        assertEquals(3000, orderList.get(1).getTotalPrice());
        assertEquals(LocalDate.now(), orderList.get(1).getDate());


    }


}
