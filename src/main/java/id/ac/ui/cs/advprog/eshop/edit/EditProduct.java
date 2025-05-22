package id.ac.ui.cs.advprog.eshop.edit;

import id.ac.ui.cs.advprog.eshop.model.Product;

public class EditProduct {
    public void edit(Product P, String NewName, int NewQty) {
        P.setProductName(NewName);
        P.setProductQuantity(NewQty);
    }
}
