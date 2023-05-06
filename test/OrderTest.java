import model.Category;
import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class OrderTest {

    public void setupStange1(){
        Order order= new Order("Santiago", 2000, LocalDate.now());
        Product product1= new Product("ProductA" , "xxxxA", 1000,  1 ,Category.BOOKS);
        Product product2= new Product("ProductB" , "xxxxB", 1000,  2 , Category.FOOD_AND_DRINKS);
        //Agregar los productos a la lista de order
    }

    @Test
    public void createNewOrderTest(){
        assertTrue(false);
    }
    @Test
    public void addNewProductToOrderTest(){
        assertTrue(false);
    }
}
