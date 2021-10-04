package nl.novi.firstdemo.service;

import nl.novi.firstdemo.exception.RecordNotFoundException;
import nl.novi.firstdemo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomer(int id) {
        try {
            return customers.get(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void deleteCustomer(int id) {
        try {
            customers.remove(id);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
    }

    public void updateCustomer(int id, Customer customer) {
        try {
            customers.set(id, customer);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException("Customer with id " + id + " not found.");
        }
    }

}
