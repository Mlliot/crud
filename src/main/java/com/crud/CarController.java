package com.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CarController {

    @Autowired
    private Service carService;

    // Save
    @PostMapping("/cars")
    public Car saveCar(@Valid @RequestBody Car car) {
        return carService.saveCar(car);
    }

    // Read
    @GetMapping("/cars")
    public List<Car> fetchCarList() {
        return carService.fetchCarList();
    }

    // Update
    @PutMapping("/cars/{id}")
    public Car updateCar(@RequestBody Car car,
            @PathVariable("id") Long carId) {
        return carService.updateCar(
                car, carId);
    }

    // Delete
    @DeleteMapping("/cars/{id}")
    public String deleteCarById(
            @PathVariable("id") Long carId) {
        carService.deleteCarById(
                carId);
        return "Deleted Successfully";
    }
}
