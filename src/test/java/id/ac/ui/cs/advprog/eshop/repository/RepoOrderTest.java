package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class RepoOrderTest {
    RepoOrder repoOrder;

    List<Order>;

    @BeforeEach
    void setUp(){
        repoOrder = new RepoOrder();

        List<Product> products = new ArrayList<>();
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
        Order o3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbfle", this.products,
                1708560000L, "Safira Sudrajat");
        orders.add(o3);
    }

    @Test
    void testSaveCreate() {
        Order o = orders.get(1);
        Order r = repoOrder.save(o);

        Order fr = repoOrder.findById(orders.get(1).getId());
        assertEquals(o.getId(), r.getId());
        assertEquals(o.getId(), fr.getId());
        assertEquals(o.getOrderItem(), fr.getOrderTime());
        assertEquals(o.getAuthor(), fr.getAuthor());
        assertEquals(o.getStatus(), fr.getStatus());
    }

    @Test
    void testSaveUpdate() {
        Order o= new Order();
        repoOrder.save(o);
        Order no = new Order(o.getId(), o.getProducts(), o.getOrderTime(), o.getAuthor(),
                o.getStatusS.SUCCESS.getValue());
        Order result = repoOrder.save(no);

        Order fr = repoOrder.findById(orders.get(1).getId());
        assertEquals(o.getId(), result.getId());
        assertEquals(o.getId(), fr.getId());
        assertEquals(o.getOrderTime(), fr.getOrderTime()));
        assertEquals(o.getAuthor(), fr.getAuthor());
        asertEquals(oOrderStatus.SUCCESS.getValue(), fr.getStatus());
    }

    @Test
    void testFindByIdFound() {
        for Order o : orders) {
            repoOrder.save(o);
        }

        Order fr repoOrder.findById(orders.get(1).getId());
        assertEquals(orders.get(1).getId(), fr.getId());
        assertEquals(orders.get(1).getOrderTime(), fr.getOrderTime());
        assertEquals(orders.get(1).getAuthor(), fr.getAuthor());
        assertEquals(orders.get(1).getStatus, fr.getStatus());
    }

    @Test
    void testByIdNotFound() {
        for (Order o : orders) {
            repoOrder.save(o);
        }

        Order fr = repoOrder.findById("zczc");
        assertNull(fr);
    }

    @Test
    void testFindByAuthorCorrect() {
        for (Order o : orders) {
            repoOrder.save(o);
        }

        List<Order> ol = repoOrder.findAllByAuthor(orders.get(1).getAuhtor());
        assertEquals(2, ol.size());
    }

    @Test
    void testFindAllAuthorAllLowerCase() {
        repoOrder.save(orders.get(1));

        List<Order> ol = repoOrder.findAllByAuthor(orders.get(1).getAuthor().toLowerCase());
        assertTrue(ol.isEmpty());
    }
}
