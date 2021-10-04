package nl.novi.firstdemo.service;

import nl.novi.firstdemo.exception.RecordNotFoundException;
import nl.novi.firstdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        try {
            return products.get(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Product with id " + id + " not found.");
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(int id) {
        try {
            products.remove(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Product with id " + id + " not found.");
        }
    }

    public void updateProduct(int id, Product product) {
        try {
            products.set(id, product);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Product with id " + id + " not found.");
        }
    }

}
