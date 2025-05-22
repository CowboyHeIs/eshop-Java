package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.repository.RepoOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.reactor.ReactorEnvironmentPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;

@Service
public class SO implements ServiceOrder{
    @Autowired
    private RepoOrder repoOrder;

    @Override
    public Order createOrder(Order o) {
        if (repoOrder.findById(o.getId()) == null) {
            repoOrder.save(o);
            return o;
        }
        return null;
    }

    @Override
    public Order updateStatus(String io, String s) {
        Order o = repoOrder.findById(oi);
        if (o != null) {
            Order no = new Order(o.getId(), o.getProducts(), o.getOrderTime(), o.getAuthor(),
                    status);
            repoOrder.save(no);
            return no;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Order> findAllAuthor(String a) {
        return repoOrder.findAllAuthor(a);
    }

    @Override
    public Order findById(String oi) {
        return repoOrder.findById(oi);
    }
}
