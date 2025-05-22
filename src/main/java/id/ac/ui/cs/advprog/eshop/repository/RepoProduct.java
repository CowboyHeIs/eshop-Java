package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class RepoProduct {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        return productData.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public void update(String productId, Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(productId)) {
                productData.set(i, updatedProduct);
                return;
            }
        }
    }
}
