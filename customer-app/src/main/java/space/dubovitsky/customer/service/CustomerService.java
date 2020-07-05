package space.dubovitsky.customer.service;

import space.dubovitsky.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(long id);

    void save(Customer customer);

    void delete(long id);

    List<Customer> getAllCustomers();

}
