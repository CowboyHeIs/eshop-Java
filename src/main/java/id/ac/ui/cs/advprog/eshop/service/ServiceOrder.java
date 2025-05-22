package id.ac.ui.cs.advprog.eshop.service;

public interface ServiceOrder {

    Order createOrder(Order o);

    Order updateStatus(String oi, String s);

    Order findById(String id);

    List<Order> findAllAuthor(String a);
}
