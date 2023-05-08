
import model.Order;
import model.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersTest {

    private Orders orders;

    public void setupStange2() {
        orders = new Orders();
        Order order = new Order("Santiago", 2000, LocalDate.now());
        // agregar la orden a las ordenes
    }

    @BeforeEach
    void setup() {
        orders = new Orders();
    }

    public void setupStange1() {
        orders = new Orders();
        Order order = new Order("Azul", 2000, LocalDate.of(2023, 4, 24));
        Order order2 = new Order("Betty", 55000, LocalDate.of(2023, 4, 6));
        Order order3 = new Order("Homero", 48000, LocalDate.of(2023, 4, 9));
        Order order4 = new Order("Daniela", 10000, LocalDate.of(2023, 4, 1));
        Order order5 = new Order("Carmen", 39000, LocalDate.of(2023, 4, 7));
        // Agrega las órdenes a la instancia de "orders"
        orders.addOrder(order);
        orders.addOrder(order2);
        orders.addOrder(order3);
        orders.addOrder(order4);
        orders.addOrder(order5);
    }

    @Test
    void searchOrderSuccessfullyByNameTest() {
        Order order1 = new Order("John", 100.0, LocalDate.of(2023, 5, 1));
        Order order2 = new Order("Jane", 200.0, LocalDate.of(2023, 5, 2));
        Order order3 = new Order("John", 150.0, LocalDate.of(2023, 5, 3));

        Orders orders = new Orders();
        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);

        List<Order> result = orders.searchOrderByBuyerName("John");

        assertEquals(2, result.size());
        assertEquals(order1, result.get(0));
        assertEquals(order3, result.get(1));
    }



    @Test
    void searchOrdersSuccessfullyByPriceTest() {
        Order order1 = new Order("John", 100.0, LocalDate.of(2023, 5, 1));
        Order order2 = new Order("Jane", 200.0, LocalDate.of(2023, 5, 2));
        Order order3 = new Order("John", 150.0, LocalDate.of(2023, 5, 3));

        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);

        List<Order> result = orders.searchOrderByTotalPrice(200.0);

        assertEquals(1, result.size());
        assertEquals(order2, result.get(0));
    }

    @Test
    void searchOrdersSuccessfullyByDateTest() {
        Orders orders = new Orders();

        Order order1 = new Order("John", 100.0, LocalDate.of(2023, 5, 1));
        Order order2 = new Order("Jane", 200.0, LocalDate.of(2023, 5, 2));
        Order order3 = new Order("John", 150.0, LocalDate.of(2023, 5, 3));

        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);

        List<Order> result = orders.searchOrderByDate(LocalDate.of(2023, 5, 2));

        assertEquals(1, result.size());
        assertEquals(order2, result.get(0));
    }


}

