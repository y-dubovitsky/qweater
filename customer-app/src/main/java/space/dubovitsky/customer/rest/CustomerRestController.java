package space.dubovitsky.customer.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import space.dubovitsky.customer.model.Customer;
import space.dubovitsky.customer.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/customers/")
public class CustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(
            @PathVariable("id") Long customerId
    ) {
        if (customerId != null) {
            Customer byId = customerService.getById(customerId);
            if (byId == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //https://java.fandom.com/ru/wiki/@RequestMapping
    public ResponseEntity<Customer> saveCustomer(
            @RequestBody @Validated Customer customer
    ) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }

        this.customerService.save(customer);
        return new ResponseEntity<>(customer, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody @Validated Customer customer,
            UriComponentsBuilder builder
    ) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerService.save(customer);

        return new ResponseEntity<>(customer, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(
            @PathVariable(value = "{id}") long id
    ) {
        if (customerService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (allCustomers != null) {
            return new ResponseEntity<>(allCustomers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
