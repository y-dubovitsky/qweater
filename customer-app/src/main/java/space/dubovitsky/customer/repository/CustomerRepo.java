package space.dubovitsky.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
