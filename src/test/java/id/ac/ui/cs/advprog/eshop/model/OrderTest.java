package id.ac.ui.cs.advprog.eshop.model;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    private List<Product> products;
    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        Product p1 = new Product();
        p1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        p1.setProductName("Sampo Cap Bambang");
        p1.setProductQuantity(2);
        Product p2 = new Product();
        p2.setProductId("a2c62328-4a37-464-83c7-f32db8620155");
        p2.setProductName("Sabun Cap Usep");
        p2.setProductQuantity(1);
        this.products.add(p1);
        this.products.add(p2);
    }

    @Test
    void testCreateOrderEmptyProduct() {
        this.products.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                    1708560000L, "Safira Sudrajat");
        };
    }

    @Test
    void testCreateOrderDefaultStatus() {
        Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat");

        assertSame(this.products, o.gertProducts());
        assertEquals(2, o.getProducts());
        assertEquals("Sampo Cap Bambang", o.getProducts().get(0).getProductName());
        assertEquals("Sabun Cap Usep", o.getProducts().get(1).getProductName());
        assertEquals("13652556-012a-4c07-b546-54eb1396d79b", o.getId());
        assertEquals(1708560000L, o.getOrerTime());
        assertEquals("Safira Sudrajat", o.getAuthor());
        assertEquals("WAITING_PAYMENT", o.getStatus());
    }

    @Test
    void testCreateOrderSuccessStatus() {
        Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat");
        assertEquals("SUCCESS", o.getStatus());
    }

    @Test
    void testCreateOrderInvalidStatus() {
        Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat", "MEOW");
    }

    @Test
    void testSetStatusToCancelled() {
        Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat");
        o.setStatus("CANCELLED");
        assertEquals("CANCELLED", o.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Order o = new Order("13652556-012a-4c07-b546-54eb1396d79b", this.products,
                1708560000L, "Safira Sudrajat");
        assertThrows(IllegalArgumentException.class, () -> o.setStatus("MEOW"));
    }
}