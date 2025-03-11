package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.EditProduct;
import id.ac.ui.cs.advprog.eshop.repository.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class ServiceProductImpl implements ServiceProduct {

    @Autowired
    private RepoProduct productRepository;

    @Override
    public Product create(Product product) {
        product.setProductId(java.util.UUID.randomUUID().toString());
        productRepository.create(product);
        return product;
    }


    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product edit(EditProduct editProduct) {
        List<Product> products = findAll();
        for (Product product : products) {
            if (product.getProductId().equals(editProduct.getProductId())) {
                product.setProductName(editProduct.getNewProductName());
                product.setProductQuantity(editProduct.getNewProductQuantity());
                return product;
            }
        }
        return null;
    }

    @Override
    public Product update(EditProduct editProduct) {
        Product existingProduct = productRepository.findById(editProduct.getProductId());
        if (existingProduct != null) {
            existingProduct.setProductName(editProduct.getNewProductName());
            existingProduct.setProductQuantity(editProduct.getNewProductQuantity());
        }
        return existingProduct;
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
        }
    }
}
