package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.EditProduct;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ServiceProduct;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TestCtrlProduct {

    @Test
    void TestEditProduct() {
        ServiceProduct mockService = mock(ServiceProduct.class);
        CtrlProduct controller = new CtrlProduct(mockService);
        Model mockModel = mock(Model.class);

        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Old Name");
        product.setProductQuantity(5);

        when(mockService.findById("1")).thenReturn(product);

        String view = controller.editProductPage("1", mockModel);

        assertEquals("editProduct", view);
        verify(mockModel).addAttribute(eq("editProduct"), any(EditProduct.class));
    }

    @Test
    void TestDeleteProduct() {
        ServiceProduct mockService = mock(ServiceProduct.class);
        CtrlProduct controller = new CtrlProduct(mockService);

        String result = controller.delete("1");

        assertEquals("redirect:/product/list", result);
        verify(mockService).delete("1");
    }
}
