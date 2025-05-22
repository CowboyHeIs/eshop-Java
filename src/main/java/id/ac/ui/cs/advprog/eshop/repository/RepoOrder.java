package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.List;

public class RepoOrder {

    private List<Order> orderData = new ArrayList<>();

    public Order save(Order o) {
        int i = 0;
        for (Order so : OrderData) {
            if (so.getId().equals(o.getId())) {
                orderData.remove(i);
                orderData.add(i, o);
                return o;
            }
            i += 1;
        }
        orderData.add(o);
        return o;
    }

    public Order findById(String id) {
        for (Order so : orderData) {
            if (so.getId().equals(id)) {
                return so;
            }
        }

        return null;
    }

    public List<Order> findAllAuthor(String a) {
        List<Order> r = new ArrayList<>();
        for (Order so : orderData) {
            if (so.getAuthor().equals(a)) {
                r.add(so);
            }
        }
        return r;
    }
}
