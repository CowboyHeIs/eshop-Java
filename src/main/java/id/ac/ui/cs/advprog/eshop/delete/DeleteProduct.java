package id.ac.ui.cs.advprog.eshop.delete;

import java.util.List;
import id.ac.ui.cs.advprog.eshop.model.Product;

public class DeleteProduct {
    public void delete(List<Product> Products, String Id) {
        Products.removeIf(P -> P.getProductId().equals(Id));
    }
}
