package space.dubovitsky.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.spring.data.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}
