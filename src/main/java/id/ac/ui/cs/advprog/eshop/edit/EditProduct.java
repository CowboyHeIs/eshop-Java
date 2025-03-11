package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EditProduct {
    private String productId;
    private String newProductName;
    private int newProductQuantity;
}
