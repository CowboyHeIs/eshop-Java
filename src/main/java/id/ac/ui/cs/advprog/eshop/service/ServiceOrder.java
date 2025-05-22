package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import java.util.List;

public interface ServiceOrder {

    Order createOrder(Order o);

    Order updateStatus(String oi, String s);

    Order findById(String id);

    List<Order> findAllAuthor(String a);
}
