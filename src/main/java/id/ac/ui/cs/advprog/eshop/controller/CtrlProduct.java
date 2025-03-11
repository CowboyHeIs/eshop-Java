package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ServiceProduct;
import id.ac.ui.cs.advprog.eshop.model.EditProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class CtrlProduct {

    @Autowired
    private ServiceProduct service;

    @GetMapping("/create")
    public String productCreatePage(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        service.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String listProductPage(Model model) {
        model.addAttribute("products", service.findAll());
        return "listProduct";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable String id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            return "redirect:/product/list";
        }
        EditProduct editProduct = new EditProduct();
        editProduct.setProductId(id);
        editProduct.setNewProductName(product.getProductName());
        editProduct.setNewProductQuantity(product.getProductQuantity());
        model.addAttribute("editProduct", editProduct);
        return "editProduct";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedProduct(@PathVariable String id, @ModelAttribute EditProduct editProduct) {
        service.update(editProduct);
        return "redirect:/product/list";
    }

}
