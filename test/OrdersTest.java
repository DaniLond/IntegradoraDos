
import model.Order;
import model.Orders;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrdersTest {

    private Orders orders;
    public void setupStange2(){
        orders= new Orders();
        Order order= new Order("Santiago", 2000, LocalDate.now());
        // agregar la orden a las ordenes
    }

    public void setupStange1(){
        orders= new Orders();
        Order order= new Order("Azul", 2000, LocalDate.of(2023, 4, 24));
        Order order2= new Order("Betty", 55000, LocalDate.of(2023, 4, 6));
        Order order3= new Order("Homero", 48000, LocalDate.of(2023, 4, 9));
        Order order4= new Order("Daniela", 10000, LocalDate.of(2023, 4, 1));
        Order order5= new Order("Carmen", 39000, LocalDate.of(2023, 4, 7));
        // agregar la orden a las ordenes
    }

    @Test
    public void addOrderToOrdersTest(){
       assertTrue(false);
    }

    @Test
    void searchOrderSuccessfullyByNameTest(){
        assertTrue(false);
    }

    @Test
    void searchOrdersSuccessfullyByPriceTest(){
        assertTrue(false);
    }

    @Test
    void searchOrdersSuccessfullyByDateTest(){
        assertTrue(false);
    }

    @Test
    void searchOrderSuccessfullyByBuyerTest(){
        assertTrue(false);
    }

    @Test
    public void searchRangeNumericalValueTest(){
        assertTrue(false);
    }

    @Test
    public void searchRangeStringTypeTest(){
        assertTrue(false);
    }
}
