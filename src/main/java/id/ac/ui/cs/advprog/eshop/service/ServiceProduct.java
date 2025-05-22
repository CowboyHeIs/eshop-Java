package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ServiceProduct {
    public Product create(Product product);
    public List<Product> findAll();
    Product findById(String productId);
    void update(String productId, Product product);
}
