package space.dubovitsky.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.dubovitsky.spring.data.model.Car;
import space.dubovitsky.spring.data.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findCarById(int id) {
        return carRepository.findById(id).get();
    }

}
