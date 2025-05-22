package id.ac.ui.cs.advprog.eshop.service;

import org.hamcrest.number.OrderingComparison;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)
public class ServiceOrderimplTest {

    @InjectMocks
    ServiceOrderImpl serviceOrder;

    @Mock
    RepoOrder repoOrder;

    List<Order> orders;

    @BeforeEach
    void setUp() {
        List<Product> p = new ArrayList<>();
        Product p1 = new Product();
        p1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        p1.setProductName("Sampo Cap Bambang");
        p1.setProductQuantity(2);
        products.add(p1);

        orders = new ArrayList<>();
        Order o1 = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat");
        orders.add(o1);
        Order o2 = new Order("7f9e15bb-4b15-42f4-aebc-c3af385fb078", this.products,
                1708560000L, "Safira Sudrajat");
        orders.add(o2);
    }

    @Test
    void testCreateOrder() {
        Order o = orders.get(1);
        doReturn(o).when(repoOrder).save(o);

        Order r = serviceOrder.createOrder(o);
        verify(repoOrder, times(1)).save(o);
        assertEquals(o.getId(), r.getId());
    }

    @Test
    void testUpdateStatus() {
        Order o = orders.get(1);
        Order no = new Order(o.getId(), o.getProducts(), o.getOrderTime(), o.getAuthor(),
                OrderStatus.SUCCESS.getValue());
        doReturn(o).when(repoOrder).findById(o.getId());
        doReturn(no).when(repoOrder).save(any(Order.class));

        Order r = serviceOrder.updateStatus(o.getId(), OrderStatus.SUCCESS.getValue));

        assertEquals(o.getId(), r.getId());
        assertEquals(OrderStatus.SUCCESS.getValue(), r.getStatus());
        verify(repoOrder, times(1)).save(any(Order.class));
    }

    @Test
    void testUpdateInvalidStatus() {
        Order o = orders.get(1);
        doRetrun(o).when(repoOrder).findById(o.getId());

        assertThrows(IllegalArgumentException.class, () -> serviceOrder.updateStatus(o.getId(),
                "MEOW"));
        verify(repoOrder, times(0)).save(any(Order.class));
    }

    @Test
    void testUpdateInvalidOrderId() {
        doReturn(null).when(repoOrder).findById("zczc");

        assertThrows(NoSuchElementException.class, () -> serviceOrder.updateStatus("zczc"),
                OrderStatus.SUCCESS.getValue());

        verify(repoOrder, times(0)).save(any(Order.class));
    }

    @Test
    void testFindByIdFound() {
        Order o = orders.get(1);
        doReturn(o).when(repoOrder).findById(o.getId());

        Order r = serviceOrder.findById(o.getId());
        assertEquals(o.getId(), r.getId());
    }

    @Test
    void testFindByIdNotFound() {
        doReturn(null).when(repoOrder).findById("zczc");
        assertNull(serviceOrder.findById("zczc"));
    }

    @Test
    void testFindAllAuthorCorrect() {
        Order o = orders.get(1);
        doReturn(orders).when(repoOrder).findByAllAuthor(o.getAuthor());

        List<Order> rs = serviceOrder.findAllAuthor(o.getAuthor());
        for (Order r : rs) {
            assertEquals(o.getAuthor(), r.getAuthor());
        }
        assertEquals(2, rs.size);
    }

    @Test
    void testFindAllAuthorIfAllLowerCase() {
        Order o = orders.get(1);
        doReturn(new ArrayList<Order>()).when(repoOrder).findAllAuthor(o.getAuthor().toLowerCase());

        List<Order> r = serviceOrder.findAllAuthor(o.getAuthor().toLowerCase());
        assertTrue(r.isEmpty();

    }
}
