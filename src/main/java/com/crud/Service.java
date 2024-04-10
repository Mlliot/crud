package com.crud;

import java.util.List;

//interface for CarService
public interface Service {

    // Save
    Car saveCar(Car car);

    // Read
    List<Car> fetchCarList();

    // Update
    Car updateCar(Car car, Long carId);

    // Delete
    void deleteCarById(Long carId);

}
