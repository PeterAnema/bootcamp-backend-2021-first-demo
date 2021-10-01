package nl.novi.firstdemo.controller;

import nl.novi.firstdemo.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private static List<Product> products = new ArrayList<>();

    @GetMapping(value = "/products")
    public List<Product> getProduct() {
        return products;
    }

    @GetMapping(value = "/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.get(id);
    }

    @PostMapping(value = "/products")
    public String addProduct(@RequestBody Product product) {
        products.add(product);
        return "Added product";
    }

    @DeleteMapping(value = "/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        products.remove(id);
        return "Removed product";
    }

    @PutMapping(value = "/products/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        products.set(id, product);
        return "Updated product";
    }

}