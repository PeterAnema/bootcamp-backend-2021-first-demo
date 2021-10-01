package nl.novi.firstdemo.controller;

import nl.novi.firstdemo.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private static List<Customer> customers = new ArrayList<>();

    public CustomerController() {
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping(value = "/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customers.get(id);
    }

    @PostMapping(value = "/customers")
    public String addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "Added customer";
    }

    @DeleteMapping(value = "/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customers.remove(id);
        return "Removed customers";
    }

    @PutMapping(value = "/customers/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customers.set(id, customer);
        return "Updated customer";
    }

}
