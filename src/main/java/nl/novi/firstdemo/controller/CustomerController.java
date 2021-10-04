package nl.novi.firstdemo.controller;

import nl.novi.firstdemo.exception.RecordNotFoundException;
import nl.novi.firstdemo.model.Customer;
import nl.novi.firstdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "Added";
    }

    @DeleteMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "Removed";
    }

    @PutMapping(value = "/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return "Updated";
    }

}
