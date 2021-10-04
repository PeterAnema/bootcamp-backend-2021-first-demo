package nl.novi.firstdemo.controller;

import nl.novi.firstdemo.exception.RecordNotFoundException;
import nl.novi.firstdemo.model.Product;
import nl.novi.firstdemo.model.Product;
import nl.novi.firstdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PostMapping(value = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public String addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return "Added";
    }

    @DeleteMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Removed";
    }

    @PutMapping(value = "/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return "Updated";
    }

}