package space.dubovitsky.customer.service.impl;

import org.springframework.stereotype.Service;
import space.dubovitsky.customer.model.Customer;
import space.dubovitsky.customer.repository.CustomerRepo;
import space.dubovitsky.customer.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(long id) {
        return customerRepo.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        if (customer != null) {
            customerRepo.save(customer);
        }
    }

    @Override
    public void delete(long id) {
        customerRepo.delete(customerRepo.getOne(id)); //?TODO Поправить?
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
