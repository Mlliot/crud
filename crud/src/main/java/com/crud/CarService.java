package com.crud;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service which is driven by CarController 
@Service
public class CarService implements com.crud.Service {

    @Autowired
    private CarRepository carRepository;

    // Save
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // Read
    @Override
    public List<Car> fetchCarList() {
        return (List<Car>) carRepository.findAll();
    }

    // Update
    @Override
    public Car updateCar(Car car, Long carId) {
        Car carDB = carRepository.findById(carId).get();

        if (Objects.nonNull(car.getModel())
                && !"".equalsIgnoreCase(car.getModel())) {
            carDB.setModel(car.getModel());
        }

        if (Objects.nonNull(car.getMake())
                && !"".equalsIgnoreCase(car.getMake())) {
            carDB.setMake(car.getMake());
        }

        return carRepository.save(carDB);
    }

    @Override
    public void deleteCarById(Long carId) {
        carRepository.deleteById(carId);
    }

}
