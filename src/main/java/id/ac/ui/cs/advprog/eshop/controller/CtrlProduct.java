package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ServiceCarImpl;
import id.ac.ui.cs.advprog.eshop.service.ServiceProduct;

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
	public String createProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
        return "createProduct";
	}

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "listProduct";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProducPost(@ModelAttribute Product product, Model model) {
        System.out.println(product.getProductId());
        service.update(product.getProductId(), product);

        return "redirect:list";

    }
}

@Controller
@RequestMapping("/car")
class CtrlCar extends CtrlProduct{
    @Autowired
    private ServiceCarImpl serviceCar;

    @GetMapping("/createCar")
    public String createCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }

    @PostMapping("createCar")
    public String createCarPost(@ModelAttribute Car car, Model model) {
        serviceCar.create(car);
        return "redirect:listCar";
    }

    @GetMapping("/listCar")
    public String carListPage(Model model){
        List<Car> allCars = serviceCar.findAll();
        model.addAttribute("cars", allCars);
        return "carList";
    }

    @GetMapping("/editCar/{carId}")
    public String editCarPage(@PathVariable String carId, Model model) {
        Car car = serviceCar.findById(carId);
        model.addAttribute("car", car);
        return "editCar";
    }

    @PostMapping("/editCar")
    public String editCarPost(@ModelAttribute Car car, Model model) {
        System.out.println(car.getCarId());
        serviceCar.update(car.getCarId(), car);
        return "redirect:listCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") String carId) {
        serviceCar.deleteCarById(carId);
        return "redirect:listCar";
    }
}
