package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.EditProduct;
import java.util.List;

public interface ServiceProduct {
    public Product create(Product product);
    public List<Product> findAll();
    public Product edit(EditProduct editProduct);
    public Product findById(String id);
    public Product update(EditProduct editProduct);


}
