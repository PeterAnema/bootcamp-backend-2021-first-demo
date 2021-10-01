package nl.novi.firstdemo.controller;

import nl.novi.firstdemo.exception.RecordNotFoundException;
import nl.novi.firstdemo.model.Customer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private static List<Customer> customers = new ArrayList<>();

    public CustomerController() {
    }

    @GetMapping(value = "/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable int id) {
        try {
            return customers.get(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
    }

    @PostMapping(value = "/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return "Added customer";
    }

    @DeleteMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteCustomer(@PathVariable int id) {
        try {
            customers.remove(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
        return "Removed customers";
    }

    @PutMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            customers.set(id, customer);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
        return "Updated customer";
    }

}
